public class Item {
	private String itemname;
	private double price;
	private double discount;
	private double itemDiscountPercent; // Added for printReceipt() method in GroceryBill to print the percentage discount

	public Item(String itemname, double price, double discount, double itemDiscountPercent) { // Constructs new item with name, price, and discount
		this.itemname = itemname;
		this.price = price;
		this.discount = discount;
		this.itemDiscountPercent = itemDiscountPercent;
	}

	public String getItemName() { // Gets the name of this item
		return this.itemname;
	}

	public double getPrice() { // Gets the price of this item
		return this.price;
	}

	public double getDiscount() { // Gets the discount of this item
		return this.discount;
	}

	public double getitemDiscountPercent() {
		return this.itemDiscountPercent;
	}
}
