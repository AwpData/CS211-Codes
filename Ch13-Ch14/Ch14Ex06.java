
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
		System.out.println("isPalindrome returns: " + isPalindrome(q));
		System.out.println("Queue state after isPalindrome: " + q);

		q.clear();

		// Adds 10 random numbers to queue that are not in palindrome pattern (hopefully it randomly isn't a palindrome)
		for (int i = 0; i < 10; i++) {
			q.add((int) ((int) 1 + Math.random() * 100));
		}
		System.out.println("\nQueue state before isPalidrome: " + q);
		System.out.println("isPalindrome returns: " + isPalindrome(q));
		System.out.println("Queue state after isPalindrome: " + q);

	}

	// Method to test if a queue is in palindrome pattern
	public static boolean isPalindrome(Queue<Integer> q) {
		Stack<Integer> tempStack = new Stack<>(); // Our one auxilary stack storage unit
		int queueSize = q.size();
		if (q.size() == 0) { // Since the book said that empty queues are palindromes
			return true;
		}
		for (int i = 0; i < queueSize; i++) { // Adds the numbers from queue to temporary stack
			int queueNum = tempStack.push(q.remove());
			q.add(queueNum);
		}

		boolean palindrome = true; // At this instance, the queue is a palindrome
		while (!tempStack.isEmpty()) {
			int stackNum = tempStack.pop(); // Pops the last element off stack
			int queueNum = q.remove(); // Removes the first element in queue
			q.add(queueNum); // Re-adds the queueNum so that the queue is in its original state
			if (stackNum != queueNum) { // If these numbers arn't equal to each other (Since the numbers should be mirrored to each other in a palindrome)
				palindrome = false; // Set palindrome to false (don't return as the queue won't be in original state)
			}
		}
		return palindrome; // Returns whether this queue is a palindrome or not
	}
}
