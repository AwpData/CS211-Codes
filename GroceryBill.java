import java.util.ArrayList;

public class GroceryBill {
	private ArrayList<Item> bill;
	private int total;
	private boolean preferred;

	public GroceryBill(String clerk, boolean preferred) {
		this.total = 0;
		this.bill = new ArrayList<>();
		this.preferred = preferred;
	}

	public void add(Item i) {
		bill.add(i);
	}

	public double getTotal() {
		double total = 0;
		for (Item item : bill) {
			total += item.getPrice();
		}
		return total;
	}

	public ArrayList<Item> getBill() {
		return this.bill;
	}

	public void printReceipt() {
		for (Item item : bill) {
			if (preferred) {
				System.out.println(item.getItemName() + " " + item.getPrice() + " - discount " + item.getDiscount() + " = " + (item.getPrice() - item.getDiscount()));
			} else {
				System.out.println(item.getItemName() + " " + item.getPrice());
			}
		}
	}
}
