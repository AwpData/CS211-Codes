import java.util.ArrayList;

public class GroceryBill {
	private ArrayList<Item> bill;
	private boolean preferred;

	public GroceryBill() { // Default Constructor
		this.bill = new ArrayList<>();
		this.preferred = false;
	}

	public GroceryBill(Employee Clerk, boolean preferred) { // I added preferred to use in the printReceipt() method if the person has discounts
		this.bill = new ArrayList<>();
		this.preferred = preferred;
	}

	public void add(Item i) { // adds the item to the bill
		bill.add(i);
	}

	public void printReceipt() { // Prints each item on receipt (totals are calculated in client)
		int counter = 1; // Used to list items in receipt
		if (bill.size() == 0) {
			System.out.println("Nothing purchased!\n");
		} else {
			for (Item item : bill) {
				if (preferred && item.getDiscount() > 0) {
					System.out.printf("%d. %s $%.2f (%.2f%% discount of $%.2f) off of $%.2f\n", counter, item.getItemName(), (item.getPrice() - item.getDiscount()), item.getitemDiscountPercent(), item.getDiscount(), item.getPrice());
				} else {
					System.out.printf("%d. %s $%.2f\n", counter, item.getItemName(), item.getPrice());
				}
				counter++;
			}
		}
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
}
