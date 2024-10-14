package Model;

public class MenuItem {
    private static int itemCounter = 0;
    private int itemId;
    private String name;
    private double price;

    public MenuItem(int id , String name, double price) {
        this.itemId = id;
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
