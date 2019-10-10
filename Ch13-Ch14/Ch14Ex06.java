
/* Name: Trevor Tang
 * Course: CS 211
 * Date: October 13, 2019
 * Reason: Program uses queues and stacks to determine if a given Integer queue is in palindrome form 
 */

import java.util.*;

public class Ch14Ex06 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();

		// Adds numbers 0-5 then 5-0 to queue
		for (int i = 0; i < 5; i++) {
			q.add(i);
		}
		for (int i = 5; i >= 0; i--) {
			q.add(i);
		}
		System.out.println("Queue state before isPalidrome: " + q);
		System.out.println("Queue state after isPalindrome: " + q);
		System.out.println("isPalindrome returns: " + isPalindrome(q));

		q.clear();

		// Adds 10 random numbers to queue that are not in palindrome pattern (hopefully it randomly isn't a palindrome)
		for (int i = 0; i < 10; i++) {
			q.add((int) ((int) 1 + Math.random() * 100));
		}
		System.out.println("\nQueue state before isPalidrome: " + q);
		System.out.println("Queue state after isPalindrome: " + q);
		System.out.println("isPalindrome returns: " + isPalindrome(q));

	}

	// Method to test if a queue is in palindrome pattern
	public static boolean isPalindrome(Queue<Integer> q) {
		Stack<Integer> tempStack = new Stack<>(); // Our one auxilary stack storage unit
		int queueSize = q.size();
		int totalNumbers = 0; // Counter to keep track of how many numbers are palindromes
		if (q.size() == 0) { // Since the book said that empty queues are palindromes
			return true;
		}
		for (int i = 0; i < queueSize; i++) { // Adds the numbers from queue to temporary stack
			int queueNum = tempStack.push(q.remove());
			q.add(queueNum);
		}
		for (int i = 0; i < queueSize; i++) {
			int stackNum = tempStack.pop(); // Gets the last element in stack
			int queueNum = q.remove(); // Gets the first element in queue
			q.add(queueNum); // Re-adds the queueNum so that the queue is in its original state
			if (totalNumbers == queueSize - 1) { // This means that all the elements in stack are palindrome to queue
				return true;
			}
			if (queueNum == stackNum) { // If the last element in stack = the first element in queue
				totalNumbers++; // Add to totalNumbers which counts the numbers in palindrome pattern
			}

		}
		return false;
	}
}
