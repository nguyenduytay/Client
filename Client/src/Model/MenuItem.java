package Model;

import javafx.scene.image.Image;

public class MenuItem {
    private static int itemCounter = 0; // Biến đếm để tạo ID tự động
    private int itemId; // ID duy nhất cho mỗi món
    private String name;
    private double price;
    private Image image;

    public MenuItem(String name, double price) {
        this.itemId = ++itemCounter; // Mỗi khi khởi tạo, ID tăng dần
        this.name = name;
        this.price = price;
    }
    public MenuItem(String name, double price , Image image) {
        this.itemId = ++itemCounter; // Mỗi khi khởi tạo, ID tăng dần
        this.name = name;
        this.price = price;
        this.image = image;
    }
    public MenuItem(int id, String name, double price) {
        this.itemId = id; // Mỗi khi khởi tạo, ID tăng dần
        this.name = name;
        this.price = price;
    }

  
    public static int getItemCounter() {
		return itemCounter;
	}
	public static void setItemCounter(int itemCounter) {
		MenuItem.itemCounter = itemCounter;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	@Override
    public String toString() {
        return "Item ID: " + itemId + " - " + name + " - " + price + " VND";
    }
}

