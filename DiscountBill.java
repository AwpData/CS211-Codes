public class DiscountBill extends GroceryBill {

	public DiscountBill(Employee Clerk, boolean preferred) {
		super(Clerk, preferred);
	}

	public int getDiscountCount() { // If the item has a discount, its discount amount > 0, and the total discount count is incremented
		int discountCount = 0;
		for (Item item : this.getBill()) {
			if (item.getDiscount() > 0) {
				discountCount++;
			}
		}
		return discountCount;
	}

	public double getDiscountAmount() { // Gets the total amount of money discounted on each item
		double discountAmount = 0.0;
		for (Item item : this.getBill()) {
			discountAmount += item.getDiscount();
		}
		return discountAmount;
	}

	public double getDiscountPercent() { // Divides the total discount amount by the total of every item without its discount in the bill
		return getDiscountAmount() / super.getTotal();
	}
}
