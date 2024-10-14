package Model;

public class ClientConnection {
    private static int connectionCounter = 0; // ID tự động tăng cho mỗi kết nối
    private int connectionId;
    private String clientId;
    private boolean isConnected;

    public ClientConnection(String clientId) {
        this.connectionId = ++connectionCounter;
        this.clientId = clientId;
        this.isConnected = false;
    }

    public boolean connectToServer(String serverAddress) {
        // Kết nối đến server
        isConnected = true;
        System.out.println("Client ID: " + connectionId + " connected to server: " + serverAddress);
        return isConnected;
    }

    public void disconnect() {
        // Ngắt kết nối
        isConnected = false;
        System.out.println("Client ID: " + connectionId + " disconnected from server.");
    }

    public boolean isConnected() {
        return isConnected;
    }

    public int getConnectionId() {
        return connectionId;
    }
}


