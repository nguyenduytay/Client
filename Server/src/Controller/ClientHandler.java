package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Model.UserAccount;

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            
            // Nhận lệnh từ client
            String command;
            while ((command = input.readLine()) != null) {
                System.out.println("Received command: " + command);
                // Xử lý lệnh tương ứng
                handleCommand(command);
            }
        } catch (IOException ex) {
            System.out.println("Client handler exception: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println("Socket close exception: " + ex.getMessage());
            }
        }
    }

    // Xử lý lệnh từ client
    private void handleCommand(String command) {
        // Giả sử command là "REGISTER_USER username password"
        String[] parts = command.split(" ");
        String action = parts[0];
        
        switch (action) {
            case "REGISTER_USER":
                String username = parts[1];
                String password = parts[2];
                UserAccount newUser = new UserAccount(username, password);
                Server.registerUser(newUser);
                output.println("User registered: " + username);
                break;

            case "DEPOSIT":
                // Nạp tiền: "DEPOSIT accountId amount"
                int accountId = Integer.parseInt(parts[1]);
                double amount = Double.parseDouble(parts[2]);
                UserAccount account = Server.getUserAccount(accountId);
                if (account != null) {
                    account.deposit(amount);
                    output.println("Deposit successful. New balance: " + account.getBalance());
                } else {
                    output.println("Account not found.");
                }
                break;

            // Thêm các trường hợp khác: gọi món, thanh toán...
            default:
                output.println("Unknown command.");
        }
    }
}
