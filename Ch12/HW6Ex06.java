/* Name: Trevor Tang 
 * Course: CS 211
 * Date: November 3, 2019
 * Reason: Recursive method that prints out inputted number but with each digit duplicated 
 */

public class HW6Ex06 {
	public static void main(String[] args) {
		System.out.print("Squares of numbers up to 8: ");
		writeSquares(8);
		System.out.println();
		System.out.print("Squares of numbers up to 6: ");
		writeSquares(6);
	}

	public static void writeSquares(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("number must be greater than 1");
		}
		if (n == 1) {
			System.out.print(n); // Base case 1 since it is the last odd number, then its even numbers
		} else if (n % 2 == 0) {
			writeSquares(n - 1);
			System.out.print(", " + (int) Math.pow(n, 2)); // Waits until base case, and then prints the even squares.
		} else if (n % 2 == 1) {
			System.out.print((int) Math.pow(n, 2) + ", "); // Prints out the odds squares first
			writeSquares(n - 1);
		}
	}
}
