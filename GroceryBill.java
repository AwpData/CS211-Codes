import java.util.ArrayList;

public class GroceryBill {
	private ArrayList<Item> bill;
	private boolean preferred;

	public GroceryBill(Employee Clerk, boolean preferred) { // I added preferred to use in the printReceipt() method if the person has discounts
		this.bill = new ArrayList<>();
		this.preferred = preferred;
	}

	public void add(Item i) { // adds the item to the bill
		bill.add(i);
	}

	public double getTotal() { // The total is calculated without any discounts
		double total = 0;
		for (Item item : bill) {
			total += item.getPrice();
		}
		return total;
	}

	public ArrayList<Item> getBill() { // Getter method for the ArrayList of items in bill
		return this.bill;
	}

	public void printReceipt() { // Prints each item on receipt (totals are calculated in client)
		if (bill.size() == 0) {
			System.out.println("Nothing purchased!");
		} else {
			for (Item item : bill) {
				if (preferred) {
					System.out.println(item.getItemName() + " $" + (item.getPrice() - item.getDiscount()) + " (discount of $" + item.getDiscount() + ") off of $" + item.getPrice());
				} else {
					System.out.println(item.getItemName() + " $" + item.getPrice());
				}
			}
		}
	}
}
