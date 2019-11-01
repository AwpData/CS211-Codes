/* Name: Trevor Tang 
 * Course: CS 211
 * Date: November 3, 2019
 * Reason: Recursive method that prints out inputted number but with each digit duplicated 
 */

public class HW6Ex04 {
	public static void main(String[] args) {
		System.out.println(doubleDigits(348));
		System.out.println(doubleDigits(-789));
	}

	public static int doubleDigits(int n) {
		if (n == 0) {
			return n;
		} else {
			int thirdNumDupe = (n % 10); // Gets the third num
			int secondNumDupe = (n % 10) * 10; // Gets the second num
			return ((doubleDigits(n / 10) * 100) + secondNumDupe + thirdNumDupe); // Returns the resultant of recursive first num + second num + third num
		}
	}
}
