// Name: Trevor Tang
// Course: CS 211
// Date: October 22, 2019
// Reason: ArrayListPlus class to showcase code of exercise methods 

// Class ArrayIntList has been converted to ArrayListPlus which is Generic Class to accept all object types

import java.util.*;

public class ArrayListPlus<E> {

	private E[] elementData; // list of type E
	private int size; // current number of elements in the list

	public static final int DEFAULT_CAPACITY = 100;

	// pre : capacity >= 0 (throws IllegalArgumentException if not)
	// post: constructs an empty list with the given capacity
	@SuppressWarnings("unchecked")
	public ArrayListPlus(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("capacity: " + capacity);
		}
		elementData = (E[]) new Object[capacity];
		size = 0;
	}

	// post: constructs an empty list of default capacity
	public ArrayListPlus() {
		this(DEFAULT_CAPACITY);
	}

	// post: returns the current number of elements in the list
	public int size() {
		return size;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: returns the object at the given index in the list
	public E get(int index) {
		checkIndex(index);
		return elementData[index];
	}

	// post: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + elementData[0];
			for (int i = 1; i < size; i++) {
				result += ", " + elementData[i];
			}
			result += "]";
			return result;
		}
	}

	// post : returns the position of the first occurrence of the given value (-1 if not found)
	public int indexOf(E value) {
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	// post: returns true if list is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}

	// post: returns true if the given value is contained in the list, false otherwise
	public boolean contains(E value) {
		return indexOf(value) >= 0;
	}

	// pre : size() < capacity (throws IllegalStateException if not)
	// post: appends the given value to the end of the list
	public void add(E value) {
		ensureCapacity(size + 1); // this public method throws the exception
		elementData[size] = value;
		size++;
	}

	// pre : size() < capacity (throws IllegalStateException if not) && 0 <= index <= size() (throws IndexOutOfBoundsException if not)
	// post: inserts the given value at the given index, shifting subsequent values right
	public void add(int index, E value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		ensureCapacity(size + 1); // this public method throws the exception
		for (int i = size; i > index; i--) {
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = value;
		size++;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: removes value at the given index, shifting subsequent values left
	public void remove(int index) {
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		elementData[index] = null;
		size--;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: replaces the element at the given index with the given value
	public void set(int index, E value) {
		checkIndex(index);
		elementData[index] = value;
	}

	// post: list is empty
	public void clear() {
		size = 0;
	}

	// pre: size() + other.size() <= capacity (throws IllegalStateException if not)
	// post: appends all values in the given list to the end of this list
	public void addAll(ArrayListPlus<E> other) {
		ensureCapacity(size + other.size);
		for (int i = 0; i < other.size; i++) {
			add((E) other.elementData[i]);
		}
	}

	// post: returns an iterator for this list
	public ArrayListIterator<E> iterator() {
		return new ArrayListIterator<E>(this); // surprising use of "this"
	}

	// post: ensures that the underlying array has the given capacity; if not, the size is doubled (or more if given capacity is even larger)
	private void ensureCapacity(int capacity) {
		if (capacity > elementData.length) {
			int newCapacity = elementData.length * 2 + 1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	// post: throws an IndexOutOfBoundsException if the given index is not a legal index of the current list
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}

	// ---------- CHAPTER 15 EXERCISES ---------- //

	// CHAPTER 15, EXERCISE 1
	// post: returns the last index of where the given value is found, -1 if not found
	public int lastIndexOf(E value) { // This accepts an integer parameter as stated in the exercise as well as all other object types
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(value)) {
				index = i; // If the element at i is equal to our value then set the index to that value
			}
		}
		return index;
	}

	// CHAPTER 15, EXERCISE 2
	// pre: L.size > 0
	// post: returns index of first occurance of first element in L in this ArrayList
	public int indexOfSubList(ArrayListPlus<E> L) {
		int counter = 0; // This keeps track if the numbers are in sequential order
		ArrayListIterator<E> iteratorList1 = new ArrayListIterator<E>(this); // Create iterator on list1
		ArrayListIterator<E> iteratorList2 = new ArrayListIterator<E>(L); // Create iterator on list2
		E value1 = iteratorList1.next(); // GET FIRST VALUE IN LIST 1
		E value2 = iteratorList2.next(); // GET FIRST VALUE IN LIST 2
		while (iteratorList1.getPosition() != this.size() + 1) { // While the iterator on list1 is not beyond size
			if (value1.equals(value2)) { // If the values equal each other
				counter++;
				if (counter == L.size()) { // If the counter is equal to the size of list2
					// Returns index of first number in list2 by getting position of list1's iterator - the size of list2
					return ((iteratorList1.getPosition()) - (L.size()));
				}
				value2 = iteratorList2.next(); // else, get the next value in list2
			} else if (iteratorList1.getPosition() == this.size()) { // If the position is actually the size, return -1
				return -1;
			}
			value1 = iteratorList1.next(); // Get the next value to compare to value2
			if (!value1.equals(value2)) { // If they don't equal each other
				// Reset the iterator on list2 back to the beginning since currently we arn't in sequential order of list2
				iteratorList2 = new ArrayListIterator<E>(L);
				value2 = iteratorList2.next(); // Get the first value now in list2 again
				counter = 0; // Reset counter to 0
			}
		}
		return -1;
	}

	// CHAPTER 15, EXERCISE 5
	// pre: given array must be Integer objects
	// post: returns an ArrayList with running totals
	public ArrayListPlus<Integer> runningTotal() {
		ArrayListPlus<Integer> a = new ArrayListPlus<>(size);
		for (int i = 0; i < size; i++) {
			int total = (int) elementData[i];
			for (int j = 0; j < i; j++) {
				total += (int) elementData[j];
			}
			a.add(total);
			total = 0;
		}
		return a;
	}

	// CHAPTER 15, EXERCISE 8
	// post: returns the number of times the value appears in the list, 0 if it does not contain it
	public int count(E value) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(value)) {
				count++;
			}
		}
		return count;
	}

	// CHAPTER 15, EXERCISE 11
	// pre: size > 0
	// post: removes the last element at (size - 1) in the given list
	public E removeLast() {
		if (this.isEmpty()) {
			throw new NoSuchElementException(); // If list is empty, throw no element exception
		}
		E value = elementData[size - 1]; // Gets the last element to return
		remove(size - 1);
		return value;
	}
}
