
public class Item {
	private String itemname;
	private double price;
	private double discount;

	public Item(String itemname, double price, double discount) {
		this.itemname = itemname;
		this.price = price;
		this.discount = discount;
	}

	public String getItemName() {
		return this.itemname;
	}

	public double getPrice() {
		return this.price;
	}

	public double getDiscount() {
		return this.discount;
	}
}
