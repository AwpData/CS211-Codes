/* Name: Trevor Tang 
 * Course: CS 211
 * Date: November 3, 2019
 * Reason: Recursive method that prints out all numbers between and including one to inputted number
 */

public class HW6Ex02 {
	public static void main(String[] args) {
		writeNums(12);
		System.out.println();
		writeNums(1);
		System.out.println();
		writeNums(20);
	}

	public static void writeNums(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		} else if (n == 1) {
			System.out.print(n); // Prints 1 without a comma to fix a classic fencepost bug
		} else {
			writeNums(n - 1);
			System.out.print(", " + n); // Prints the rest of the numbers after n > 1 and the method finishes recursively executing
		}
	}
}
