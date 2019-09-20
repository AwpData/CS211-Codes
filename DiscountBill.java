public class DiscountBill extends GroceryBill {

	public DiscountBill(String clerk, boolean preferred) {
		super(clerk, preferred);
	}

	public int getDiscountCount() {
		int discountCount = 0;
		for (Item item : this.getBill()) {
			if (item.getDiscount() > 0) {
				discountCount++;
			}
		}
		return discountCount;
	}

	public double getDiscountAmount() {
		double discountAmount = 0.0;
		for (Item item : this.getBill()) {
			discountAmount += item.getDiscount();
		}
		return discountAmount;
	}

	public double getDiscountPercent() {
		return getDiscountAmount() / super.getTotal();
	}

}
