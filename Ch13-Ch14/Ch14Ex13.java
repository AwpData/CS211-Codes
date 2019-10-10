
/* Name: Trevor Tang
 * Course: CS 211
 * Date: October 13, 2019
 * Reason: Program uses stacks to expunge integers so that the stack is in non-decreasing order 
 */

import java.util.*;

public class Ch14Ex13 {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(4);
		s.push(20);
		s.push(15);
		s.push(15);
		s.push(8);
		s.push(5);
		s.push(7);
		s.push(12);
		s.push(3);
		s.push(10);
		s.push(5);
		s.push(1);
		System.out.println("Before expunge: " + s);
		s = expunge(s);
		System.out.println("After expunge: " + s);

		s.clear();

		for (int i = 0; i <= 10; i++) {
			s.push((int) ((int) 1 + Math.random() * 10)); // Adds random numbers to be expunged in stack
		}
		System.out.println("\nBefore expunge: " + s);
		s = expunge(s);
		System.out.println("After expunge: " + s);
	}

	public static Stack<Integer> expunge(Stack<Integer> s) {
		Stack<Integer> tempStack = new Stack<>();
		if (s.size() < 2) {
			return s;
		}
		int numCompare = s.pop(); // Sets the first number that will be compared
		tempStack.push(numCompare); // We have to add the first number since every number after this added to the stack will be greater than this
		while (!s.isEmpty()) { // While the original stack is not empty
			int numSelected = s.pop(); // Gets the next number to be compared to numCompare
			if (numCompare <= numSelected) { // If numCompare is less than or equal to the next number in stack
				tempStack.push(numSelected); // Push it onto our tempStack as this num selected is in increasing order
				numCompare = numSelected; // Set numCompare to this number as the next number in stack to be compared has to be greater than this number to be in increasing order
			}
		}
		return tempStack;
	}
}
