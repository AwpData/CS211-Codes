/* Name: Trevor Tang 
 * Course: CS 211
 * Date: November 3, 2019
 * Reason: Recursive method that prints out the number of unique permutations of r items from a group of n items 
 */

public class HW6Ex15 {
	public static void main(String[] args) {
		System.out.println("Permut (7,4): " + permut(7, 4));
		System.out.println("Permut (6,3): " + permut(6, 3));
		System.out.println("Permut (5,2): " + permut(5, 2));
	}

	public static int permut(int n, int r) {
		if (r == 1) { // If r is one then only return N. Example: (7,4) base case will return 4
			return n;
		} else {
			return (n * permut(n - 1, r - 1)); // r is simply a statement to tell you to keep multiplying (n - 1) until r = 1 in which it multiplies by that n
			// Example: (7,4) will only return 7 * 6 * 5 * 4
		}
	}
}
