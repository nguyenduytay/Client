package Model;

public class OrderItem {
    private static int itemCounter = 0;
    private int itemId;
    private MenuItem item;
    private int quantity;

    public OrderItem(MenuItem item, int quantity) {
        this.itemId = ++itemCounter;
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    public int getItemId() {
        return itemId;
    }
    public void setQuantity(int quantity) {
    	this.quantity=  quantity;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId + " - " + item.getName() + " x " + quantity + " = " + getTotalPrice() + " VND";
    }
}
