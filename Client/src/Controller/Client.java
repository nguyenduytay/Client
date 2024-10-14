package Controller;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server. You can start sending commands.");

            UserService userService = new UserService(output, input);
            CommandHandler commandHandler = new CommandHandler(userService, scanner);

            // Khởi động luồng để nhận phản hồi từ server
            new Thread(() -> {
                try {
                    String response;
                    while ((response = input.readLine()) != null) {
                        System.out.println("Server response: " + response);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading from server: " + e.getMessage());
                }
            }).start();

            while (true) {
                System.out.print("Enter command (ADD_ITEM, REMOVE_ITEM, SEND_ORDER, VIEW_ORDER, or 'exit' to quit): ");
                String command = scanner.nextLine();

                if ("exit".equalsIgnoreCase(command)) {
                    break;
                }

                commandHandler.handleCommand(command);
            }

        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
