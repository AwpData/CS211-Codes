/* Name: Trevor Tang
 * Course: CS211
 * Date: November 10, 2019
 * Reason: Client to test chapter 17 homework exercises 
 */

public class HW08Client {
	public static void main(String[] args) {
		IntTree t = new IntTree(8);
		System.out.println("Tree structure:");
		t.printSideways();
		System.out.println();

		// CHAPTER 17, EXERCISE 1 TEST
		int x = t.countLeftNodes();
		System.out.println("Exercise 1:");
		System.out.println("Number of left tree nodes: " + x);
		System.out.println();

		// CHAPTER 17, EXERCISE 5 TEST
		System.out.println("Exercise 5:");
		System.out.println("Values on tree level 3:");
		t.printLevel(3);
		System.out.println();

		// CHAPTER 17, EXERCISE 8 TEST
		System.out.println("Exercise 8:");
		String tree = t.toString();
		System.out.println("Tree in String form:");
		System.out.println(tree);
	}
}
