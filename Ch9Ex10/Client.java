
/* Name: Trevor Tang
 * Class: CS 211
 * Date: September 22, 2019
 * Reason: Homework assignment to strengthen understanding of chapter 9 
 */

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {

		// Variables used throughout client code
		String userAnswer; // For user input
		boolean shopping = true, discountCustomer = false; // shopping determines if program quits or not, discountCustomer determines if customer is preferred
		double itemDiscountPercent = 0; // EDIT THIS TO CHANGE THE DISCOUNT (IN DECIMAL FORM)
		double itemDiscount = 0, itemDiscountTotal = 0; // Used for quick calculations in client
		GroceryBill bill; // Declares a default bill
		Scanner input = new Scanner(System.in); // Used to store user input
		Employee clerk = new Employee("Trevor");

		// Code that determines if a customer is preferred or not
		System.out.println("Welcome to my store!");
		System.out.println("Are you a preferred customer? 'Y' or 'N'");
		userAnswer = input.nextLine();
		if (userAnswer.equalsIgnoreCase("Y")) { // If the user is a preferred customer
			bill = new DiscountBill(clerk, true); // Create a discounted bill
			discountCustomer = true;
			System.out.println("Nice! You get discounts off select items"); // Gets discounts
		} else { // Not a preferred customer
			bill = new GroceryBill(clerk, false); // Not a discount customer
		}

		// User Prompts
		while (shopping) {
			System.out.println("\nWhat would you like to do? (Type #)");
			System.out.println("1. Add an item to the bill");
			System.out.println("2. Get the total of all items on bill currently (No discounts)");
			System.out.println("3. Print your receipt! (Done shopping)");
			if (discountCustomer) { // If they are discount customer they can check their percentage discount
				System.out.println("\nBONUS PREFERRED CUSTOMER OPTIONS:");
				System.out.println("4. How many items do I have discounted?");
				System.out.println("5. What is the percentage discount on my bill total?");
			}
			userAnswer = input.next();
			input.nextLine();
			System.out.println();

			// Option 1: Add an item to bill
			if (userAnswer.equals("1")) {
				System.out.println("What is the name of the item?");
				String itemName = input.nextLine();
				System.out.println("What is the price of the item?");
				double itemPrice = input.nextDouble();
				if (discountCustomer) {
					System.out.println("Is this item discounted? 'Y' or 'N'");
					input.nextLine();
					userAnswer = input.nextLine();
					if (userAnswer.equalsIgnoreCase("Y")) {
						System.out.println("What is the discount percentage off on this item?");
						itemDiscountPercent = input.nextDouble();
						if (itemDiscountPercent > 1) { // If entered as 99, it will make it 0.99 so it can be properly computed
							itemDiscountPercent /= 100;
						}
						itemDiscount = (itemPrice * itemDiscountPercent); // Calculates item discount
						itemDiscountTotal += itemDiscount; // Adds the items discount to the shopper's discount total
						System.out.printf("Took $%.2f off item price equalling $%.2f\n", itemDiscount, (itemPrice - itemDiscount));
					}
				}
				Item item = new Item(itemName, itemPrice, itemDiscount, (itemDiscountPercent * 100));
				itemDiscount = 0; // Resets in case the next item is no discount
				itemDiscountPercent = 0;
				System.out.println("Adding item to bill...");
				bill.add(item);

			// Option 2: Get total dollar amount of all items
			} else if (userAnswer.equals("2")) {
				System.out.printf("Your total is: $%.2f\n", bill.getTotal());

			// Option 3: Print the receipt and terminate program
			} else if (userAnswer.equals("3")) {
				double total = bill.getTotal();
				System.out.println("Your receipt:\n");
				bill.printReceipt(); // Prints receipt of items without without discounted total
				if (discountCustomer) {
					System.out.printf("\nYour subtotal before discounts was: $%.2f\n", total);
					total -= ((DiscountBill) bill).getDiscountAmount(); // Subtracts the discounted total from the general total
					System.out.printf("Your discounts savings: $%.2f\n", ((DiscountBill) bill).getDiscountAmount());
				}
				System.out.printf("Your total after discounts is: $%.2f\n\n", total);
				System.out.println("Your clerk today was " + clerk.getName());
				System.out.println("Thank you for shopping with us!");
				shopping = false; // ENDS PROGRAM

			// OPTION 4: If the preferred customer wants to see how many items were discounted
			} else if (userAnswer.equals("4") && discountCustomer == true) {
				System.out.printf("The number of items discounted currently: %d\n", ((DiscountBill) bill).getDiscountCount());

			// OPTION 5: If the preferred customer wants to see his percentage discount
			} else if (userAnswer.equals("5") && discountCustomer == true) {
				System.out.printf("Your discount total of all items right now is: $%.2f\n", ((DiscountBill) bill).getDiscountAmount());
				System.out.printf("This will take %d%% off your total of $%.2f equalling $%.2f\n", (int) (((DiscountBill) bill).getDiscountPercent() * 100), bill.getTotal(), (bill.getTotal() - itemDiscountTotal));

			// If the user enters an invalid command
			} else {
				System.out.println("Invalid command, try again");
			}
		}
	}
}
