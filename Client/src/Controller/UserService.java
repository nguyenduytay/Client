package Controller;

import Model.MenuItem;
import Model.OrderItem;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private PrintWriter output;
    private BufferedReader input;
    private FoodServiceManager foodService;

    public UserService(PrintWriter output, BufferedReader input) {
        this.output = output;
        this.input = input;
        this.foodService = new FoodServiceManager();
    }

    public void addItemToOrder(String itemName, int quantity) {
        MenuItem item = new MenuItem(itemName, getItemPrice(itemName)); // Phương thức để lấy giá
        foodService.addItem(item, quantity);
        System.out.println("Added " + quantity + " of " + itemName + " to your order.");
    }

    public void removeItemFromOrder(String itemName) {
        MenuItem item = new MenuItem(itemName, getItemPrice(itemName));
        foodService.removeItem(item);
        System.out.println("Removed " + itemName + " from your order.");
    }

    public void sendOrder() {
        double total = foodService.calculateTotal();
        // Gửi order tới server
        output.println("SEND_ORDER " + total); // Chỉnh sửa theo định dạng yêu cầu của server
        System.out.println("Order sent. Total: " + total);
    }

    private double getItemPrice(String itemName) {
        // Logic để lấy giá món ăn từ server hoặc từ danh sách món ăn
        return 10.0; // Giá mặc định cho ví dụ
    }
    
    public List<OrderItem> getCurrentOrderItems() {
        return foodService.getCurrentOrderItems();
    }
}
