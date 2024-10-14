package Controller;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import Model.UserAccount;

public class Server {
    private static final int PORT = 12345; // Cổng server
    private static Map<Integer, UserAccount> userAccounts = new HashMap<>(); // Quản lý tài khoản

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            
            while (true) {
                Socket socket = serverSocket.accept(); // Chấp nhận kết nối
                System.out.println("New client connected");
                
                // Tạo luồng xử lý client
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // Đăng ký tài khoản cho user
    public static void registerUser(UserAccount account) {
        userAccounts.put(account.getAccountId(), account);
        System.out.println("User registered: " + account.getUsername());
    }

    // Lấy tài khoản dựa trên ID
    public static UserAccount getUserAccount(int accountId) {
        return userAccounts.get(accountId);
    }
}
