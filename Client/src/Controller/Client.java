package Controller;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Đăng ký tài khoản
            output.println("REGISTER_USER user123 password123");
            System.out.println("Server response: " + input.readLine());

            // Nạp tiền vào tài khoản ID 1
            output.println("DEPOSIT 1 100.0");
            System.out.println("Server response: " + input.readLine());

            // Gọi các lệnh khác...

        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
