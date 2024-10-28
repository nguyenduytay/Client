package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Controller_UI.ControllerLogin;
import Utils.SocketManager;

public class Client implements Runnable {
	private static Client instance;
    private static boolean running = true; 
    public static ControllerLogin controllerLogin;
    public static String sendMessage;
    public List<String> receiMessage = new ArrayList<>();
    
    public static Client getInstance() {
        if (instance == null) {
            instance = new Client();
        }
        new Thread(instance).start();
        return instance;
    }
    @Override
    public void run() {
        SocketManager socketManager = SocketManager.getInstance();
        BufferedReader input = socketManager.getInput();
        PrintWriter output = socketManager.getOutput();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Connected to the server. You can start sending commands.");

        UserService userService = new UserService(output, input);
        CommandHandler commandHandler = new CommandHandler(userService, scanner);

        new Thread(() -> {
            try {
                String response;
                while ((response = input.readLine()) != null) {
                    System.out.println("Server response: " + response);
                    if (response.equals("LOCK")) {
                        userService.lockScreen();
                    }
                    receiMessage.add(response);
                    
                }
            } catch (IOException e) {
                System.out.println("Error reading from server: " + e.getMessage());
            }
        }).start();

        Thread sendThread = new Thread(() -> {
            try {
                while (running) {
                	if(sendMessage != "") {
                		output.println(sendMessage);
                		sendMessage = "";
                	}
                }
            } catch (Exception e) {
                System.out.println("Send thread interrupted: " + e.getMessage());
            }
        });
        sendThread.start();

        while (true) {
            System.out.print("Enter command (ADD_ITEM, REMOVE_ITEM, SEND_ORDER, VIEW_ORDER, or 'exit' to quit): ");
            String command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command)) {
                running = false;
                break;
            }

            commandHandler.handleCommand(command);
        }

        socketManager.close();
    }
}
