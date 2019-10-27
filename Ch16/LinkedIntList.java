/* Name: Trevor Tang
 * Course: CS 211
 * Date: October 27, 2019
 * Reason: LinkedIntList class used to provide creation of LinkedIntLists and showcase exercise methods from book 
 */

// Class LinkedIntList can be used to store a list of integers.

public class LinkedIntList implements IntList {
	private ListNode front; // first value in the list

	// post: constructs an empty list
	public LinkedIntList() {
		front = null;
	}

	private class ListNode { // Inner class ListNode
		public int data; // data stored in this node
		public ListNode next; // link to next node in the list

		// post: constructs a node with data 0 and null link
		public ListNode() {
			this(0, null);
		}

		// post: constructs a node with given data and null link
		public ListNode(int data) {
			this(data, null);
		}

		// post: constructs a node with given data and given link
		public ListNode(int data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}

	// post: returns the current number of elements in the list
	public int size() {
		int count = 0;
		ListNode current = front;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// pre : 0 <= index < size()
	// post: returns the integer at the given index in the list
	public int get(int index) {
		return nodeAt(index).data;
	}

	// post: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	// post : returns the position of the first occurrence of the given
	// value (-1 if not found)
	public int indexOf(int value) {
		int index = 0;
		ListNode current = front;
		while (current != null) {
			if (current.data == value) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}

	// post: appends the given value to the end of the list
	public void add(int value) {
		if (front == null) {
			front = new ListNode(value);
		} else {
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}

	// pre: 0 <= index <= size()
	// post: inserts the given value at the given index
	public void add(int index, int value) {
		if (index == 0) {
			front = new ListNode(value, front);
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = new ListNode(value, current.next);
		}
	}

	// pre : 0 <= index < size()
	// post: removes value at the given index
	public void remove(int index) {
		if (index == 0) {
			front = front.next;
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = current.next.next;
		}
	}

	// pre : 0 <= i < size()
	// post: returns a reference to the node at the given index
	private ListNode nodeAt(int index) {
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	// CHAPTER 16 EXERCISE 8
	public void switchPairs() {
		ListNode current = front;
		while (current != null) {
			if (current.next == null) { // Stops when there is a null reference to current.next (this checks for a lone number at the end too)
				break;
			} else {
				int temp = current.data; // Sets temp num to be the current nodes number
				current.data = current.next.data; // Sets this number then to be the next number
				current.next.data = temp; // Then it sets the number after (its partner) to be the temp number we stored. At this point they swapped
				current = (current.next).next; // Skips over the next value because they just swapped numbers and moves on to the next pair
			}
		}
	}

	// CHAPTER 16 EXERCISE 12
	public void split() {
		ListNode current = front;
		ListNode tempNode = null; // tempNode is used to hold the reference to the number after the negative so it isn't lost
		if (front == null) { // if list is empty do nothing
			return;
		}
		while (current.next != null) {
			if (current.next.data < 0) { // If the next node after this current node is negative
				tempNode = current.next.next; // Gets the node after the negative number node
				current.next.next = front; // Sets that node reference to then point to the front node
				front = current.next; // Sets the front node to the negative number (Since the negative number is supposed to be in front)
				current.next = tempNode; // Sets the next node then to the node that was after the negative number node
			} else {
				current = current.next; // else we will go on to the next node
			}
		}
	}

	/////////////////////////////////////////////

	// CHAPTER 16 EXERCISE 13

	public void transferFrom(LinkedIntList list2) {
		ListNode current = this.front;
		ListNode list2current = list2.front;
		while (current.next != null) {
			current = current.next;
		}
		current.next = list2current;
		list2.front = null;
	}

	// test method

	public void clear() { // MY METHOD
		front = null; // Set reference to null and let the garbage collector eat up our old list
	}

	// PRE: List is sorted in non-decreasing order
	// POST: Value is added in list at correct spot in increasing order
	public void addSorted(int value) { // IN - CLASS METHOD
		ListNode current = front;
		if (front == null || front.data > value) {
			front = new ListNode(value, front);
		} else {
			while (current.next != null) {
				if (current.next.data > value) {
					current.next = new ListNode(value, current.next);
					break;
				} else {
					current = current.next;
				}
			}
		}
	}
}
