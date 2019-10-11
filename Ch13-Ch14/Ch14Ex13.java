
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
			s.push((int) ((int) 1 + Math.random() * 100)); // Adds random numbers to be expunged in stack
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
		int numCompare = tempStack.push(s.pop()); // We have to add the first number since every number after this added to the stack will be greater than this
		while (!s.isEmpty()) { // While the original stack is not empty
			int numSelected = s.pop(); // Gets the next number to be compared to numCompare
			if (numSelected >= numCompare) { // If numCompare is less than or equal to the next number in stack
				numCompare = tempStack.push(numSelected); // Push it onto our tempStack as this num selected is in increasing order
				// Set numCompare to this numSelected as the next number added to tempStack will be greater than it
			}
		}
		while (!tempStack.isEmpty()) { // This code is here so that it reverses the list so that the output is the same as the exercise prompt
			s.push(tempStack.pop());
		}
		return s;
	}
}
