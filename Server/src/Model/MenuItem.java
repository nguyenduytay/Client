package Model;

public class MenuItem {
    private static int itemCounter = 0;
    private int itemId;
    private String linkImage;
    private String name;
    private double price;
    private int quantity;

    public MenuItem(int id ,String linkImage, String name, double price , int quantity) {
        this.itemId = id;
        this.linkImage = linkImage;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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


	public String getLinkImage() {
		return linkImage;
	}


	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
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


	@Override
    public String toString() {
        return "Item ID: " + itemId + " - " + name + " - " + price + " VND";
    }
}
