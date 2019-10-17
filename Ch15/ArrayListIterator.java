// Name: Trevor Tang
// Course: CS 211
// Date: October 22, 2019
// Reason: ArrayListIterator class used in exercise 2 

// I have edited this class to Generic to accept all object types 

import java.util.*;

public class ArrayListIterator<E> {
	private ArrayListPlus<E> list; // list to iterate over
	private int position; // current position within the list
	private boolean removeOK; // whether it's okay to remove now

	// post: constructs an iterator for the given list
	public ArrayListIterator(ArrayListPlus<E> list) {
		this.list = list;
		position = 0;
		removeOK = false;
	}

	// post: returns true if there are more elements left, false otherwise
	public boolean hasNext() {
		return position < list.size();
	}

	// pre : hasNext() (throws NoSuchElementException if not)
	// post: returns the next element in the iteration
	public E next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		E result = list.get(position);
		position++;
		removeOK = true;
		return result;
	}

	// pre : next() has been called without a call on remove (throws
	// IllegalStateException if not)
	// post: removes the last element returned by the iterator
	public void remove() {
		if (!removeOK) {
			throw new IllegalStateException();
		}
		list.remove(position - 1);
		position--;
		removeOK = false;
	}

	// USED FOR EXERCISE 2 TO GET POSITION OF ITERATOR IN GIVEN LIST
	// post: returns position index of iterator in list
	public int getPosition() {
		return position;
	}
}
