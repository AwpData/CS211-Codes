
/* Name: Trevor Tang
 * Course: CS 211
 * Date: November 17, 2019
 * Reason: HeapIntPriorityQueue class with methods from Chapter 18 exercises 9 and 11
 */

import java.util.*;

// Implements a priority queue of integers using a
// min-heap represented as an array.
public class HeapIntPriorityQueue {
	private int[] elementData;
	private int size;

	// Constructs an empty queue.
	public HeapIntPriorityQueue() {
		elementData = new int[10];
		size = 0;
	}

	// Adds the given element to this queue.
	public void add(int value) {
		// resize if necessary
		if (size + 1 >= elementData.length) {
			elementData = Arrays.copyOf(elementData, elementData.length * 2);
		}

		// insert as new rightmost leaf
		elementData[size + 1] = value;

		// "bubble up" toward root as necessary to fix ordering
		int index = size + 1;
		boolean found = false; // have we found the proper place yet?
		while (!found && hasParent(index)) {
			int parent = parent(index);
			if (elementData[index] < elementData[parent]) {
				swap(elementData, index, parent(index));
				index = parent(index);
			} else {
				found = true; // found proper location; stop the loop
			}
		}

		size++;
	}

	// Returns true if there are no elements in this queue.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns the minimum value in the queue without modifying the queue.
	// If the queue is empty, throws a NoSuchElementException.
	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return elementData[1];
	}

	// Removes and returns the minimum value in the queue.
	// If the queue is empty, throws a NoSuchElementException.
	public int remove() {
		int result = peek();

		// move rightmost leaf to become new root
		elementData[1] = elementData[size];
		size--;

		// "bubble down" root as necessary to fix ordering
		int index = 1;
		boolean found = false; // have we found the proper place yet?
		while (!found && hasLeftChild(index)) {
			int left = leftChild(index);
			int right = rightChild(index);
			int child = left;
			if (hasRightChild(index) && elementData[right] < elementData[left]) {
				child = right;
			}

			if (elementData[index] > elementData[child]) {
				swap(elementData, index, child);
				index = child;
			} else {
				found = true; // found proper location; stop the loop
			}
		}

		return result;
	}

	// Returns the number of elements in the queue.
	public int size() {
		return size;
	}

	// Returns a string representation of this queue, such as "[10, 20, 30]";
	// The elements are not guaranteed to be listed in sorted order.
	public String toString() {
		String result = "[";
		if (!isEmpty()) {
			result += elementData[1];
			for (int i = 2; i <= size; i++) {
				result += ", " + elementData[i];
			}
		}
		return result + "]";
	}

	// helpers for navigating indexes up/down the tree
	private int parent(int index) {
		return index / 2;
	}

	// returns index of left child of given index
	private int leftChild(int index) {
		return index * 2;
	}

	// returns index of right child of given index
	private int rightChild(int index) {
		return index * 2 + 1;
	}

	// returns true if the node at the given index has a parent (is not the root)
	private boolean hasParent(int index) {
		return index > 1;
	}

	// returns true if the node at the given index has a non-empty left child
	private boolean hasLeftChild(int index) {
		return leftChild(index) <= size;
	}

	// returns true if the node at the given index has a non-empty right child
	private boolean hasRightChild(int index) {
		return rightChild(index) <= size;
	}

	// switches the values at the two given indexes of the given array
	private void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	// CHAPTER 18 EXERCISE 9
	// Pre: k > 0 and k < q.size
	// Post: returns the kth smallest value in q with q maintaining its original values
	public int kthSmallest(HeapIntPriorityQueue q, int k) {
		Queue<Integer> tempQueue = new LinkedList<>();
		int counter = 1;
		if (k < 0 || k > q.size()) { // Makes sure k is a value input
			throw new IllegalArgumentException("k >= 0 || k < q.size");
		}
		while (counter < k) { // keeps on adding minimum values until it reaches the kth minimum element
			tempQueue.add(q.remove());
			counter++;
		}
		int value = q.peek(); // Gets the next min value
		while (!tempQueue.isEmpty()) { // Restores original queue
			q.add(tempQueue.remove());
		}
		return value;
	}

	// CHAPTER 18 EXERCISE 11
	// post: q has all its duplicated values removed
	public void removeDuplicates(HeapIntPriorityQueue q) {
		Queue<Integer> tempQueue = new LinkedList<>();
		while (!q.isEmpty()) {
			int currentNum = q.remove();
			if (!tempQueue.contains(currentNum)) { // If the tempQueue doesn't have this number then add it
				tempQueue.add(currentNum);
			}
		}
		while (!tempQueue.isEmpty()) { // Then since the tempQueue has no dupes, we can add it back to our priority queue to restore it
			q.add(tempQueue.remove());
		}
	}
}
