package Model;

public class MenuItem {
    private static int itemCounter = 0; // Biến đếm để tạo ID tự động
    private int itemId; // ID duy nhất cho mỗi món
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.itemId = ++itemCounter; // Mỗi khi khởi tạo, ID tăng dần
        this.name = name;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId + " - " + name + " - " + price + " VND";
    }
}

