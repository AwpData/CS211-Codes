import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		String userAnswer; // For user input
		boolean shopping = true, discountCustomer = false; // shopping determines if program quits or not, discountCustomer determines if customer is preferred
		double itemDiscountPercent = 0.20, itemDiscount = 0, itemDiscountTotal = 0; // Discount Trackers
		GroceryBill bill; // Constructs a default bill
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to my store!");
		System.out.println("Are you a preferred customer? 'Y' or 'N'");
		userAnswer = input.nextLine();
		if (userAnswer.equalsIgnoreCase("Y")) { // If the user is a preferred customer
			bill = new DiscountBill("Trevor", true);
			discountCustomer = true;
			System.out.println("Nice! You get a " + (int) (itemDiscountPercent * 100) + "% discount off all items");
		} else { // Not a preferred customer
			bill = new GroceryBill("Trevor", false);
		}
		while (shopping) {
			System.out.println("\nWhat would you like to do? (Type #)");
			System.out.println("1. Add an item to the bill");
			System.out.println("2. Get the total of all items on bill");
			System.out.println("3. Print your receipt! (Done shopping)");
			if (discountCustomer) { // If they are discount customer they can check their percentage discount
				System.out.println("4. What is the percentage discount on my bill total?");
			}
			userAnswer = input.nextLine();
			if (userAnswer.equals("1")) { // Option 1: Add an item to bill
				System.out.println("What is the name of the item?");
				String itemname = input.nextLine();
				System.out.println("What is the price of the item?");
				double itemprice = input.nextDouble();
				if (discountCustomer) {
					itemDiscount = (itemprice * itemDiscountPercent); // Calculates item discount
					itemDiscountTotal += itemDiscount; // Adds the items discount to the shopper's discount total
				}
				Item item = new Item(itemname, itemprice, itemDiscount);
				System.out.println("Adding item to bill...");
				bill.add(item);
			} else if (userAnswer.equals("2")) { // Option 2: Get total dollar amount of all items
				System.out.println("Your total is: " + bill.getTotal());

			} else if (userAnswer.equals("3")) { // Option 3: Print the receipt and terminate program
				double total = bill.getTotal();
				System.out.println("Your receipt:");
				bill.printReceipt(); // Prints receipt of items without without discounted total
				System.out.println("\nYour total is: " + total);
				if (discountCustomer) {
					total -= itemDiscountTotal; // Subtracts the discounted total from the general total
					System.out.println("Your discounts saving: " + itemDiscountTotal);
					System.out.println("Your new total is: " + total);
					System.out.println("You saved: " + (total - itemDiscountTotal));
				}
				System.out.println("\nThank you for shopping with us!");
				shopping = false; // ENDS PROGRAM
			} else if (userAnswer.equals("4") && discountCustomer == true) { // If the preferred customer wants to see his percentage discount
				System.out.println("Your discount total of all items right now is: " + itemDiscountTotal);
				System.out.println("This will take " + (int) (((DiscountBill) bill).getDiscountPercent() * 100) + "% off your total of " + bill.getTotal());
			} else {
				System.out.println("Invalid command, try again");
			}
		}
	}
}
