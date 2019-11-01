/* Name: Trevor Tang 
 * Course: CS 211
 * Date: November 3, 2019
 * Reason: Recursive method that prints out inputted number but with each digit duplicated 
 */

public class HW6Ex08 {
	public static void main(String[] args) {
		System.out.println("10 * 8 * 6 * 4 * 2 = " + multiplyEvens(5));
		System.out.println("8 * 6 * 4 * 2 = " + multiplyEvens(4));
		System.out.println("6 * 4 * 2 = " + multiplyEvens(3));
	}

	public static int multiplyEvens(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("number must be greater than 0");
		}
		if (n == 1) {
			return 2; // Base case returns 2 since it is the first even
		} else {
			return (2 * n) * multiplyEvens(n - 1); // Returns 2 * the given number * whatever the result of the next smaller even is.
		}
	}
}
