/* Name: Trevor Tang
 * Course: CS 211
 * Date: November 17, 2019
 * Reason: HashIntSet Class with the methods for Chapter 18 exercises 1, 2, and 3
 */

public class HashIntSet {
	private static final double MAX_LOAD_FACTOR = 0.75;
	private HashEntry[] elementData;
	private int size;

	// Constructs an empty set.
	public HashIntSet() {
		elementData = new HashEntry[10];
		size = 0;
	}

	// Adds the given element to this set, if it was not already
	// contained in the set.
	public void add(int value) {
		if (!contains(value)) {
			if (loadFactor() >= MAX_LOAD_FACTOR) {
				rehash();
			}

			// insert new value at front of list
			int bucket = hashFunction(value);
			elementData[bucket] = new HashEntry(value, elementData[bucket]);
			size++;
		}
	}

	// Removes all elements from the set.
	public void clear() {
		for (int i = 0; i < elementData.length; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	// Returns true if the given value is found in this set.
	public boolean contains(int value) {
		int bucket = hashFunction(value);
		HashEntry current = elementData[bucket];
		while (current != null) {
			if (current.data == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Returns true if there are no elements in this queue.
	public boolean isEmpty() {
		return size == 0;
	}

	// Removes the given value if it is contained in the set.
	// If the set does not contain the value, has no effect.
	public void remove(int value) {
		int bucket = hashFunction(value);
		if (elementData[bucket] != null) {
			// check front of list
			if (elementData[bucket].data == value) {
				elementData[bucket] = elementData[bucket].next;
				size--;
			} else {
				// check rest of list
				HashEntry current = elementData[bucket];
				while (current.next != null && current.next.data != value) {
					current = current.next;
				}

				// if the element is found, remove it
				if (current.next != null && current.next.data == value) {
					current.next = current.next.next;
					size--;
				}
			}
		}
	}

	// Returns the number of elements in the queue.
	public int size() {
		return size;
	}

	// Returns a string representation of this queue, such as "[10, 20, 30]";
	// The elements are not guaranteed to be listed in sorted order.
	public String toString() {
		String result = "[";
		boolean first = true;
		if (!isEmpty()) {
			for (int i = 0; i < elementData.length; i++) {
				HashEntry current = elementData[i];
				while (current != null) {
					if (!first) {
						result += ", ";
					}
					result += current.data;
					first = false;
					current = current.next;
				}
			}
		}
		return result + "]";
	}

	// Returns the preferred hash bucket index for the given value.
	private int hashFunction(int value) {
		return Math.abs(value) % elementData.length;
	}

	private double loadFactor() {
		return (double) size / elementData.length;
	}

	// Resizes the hash table to twice its former size.
	private void rehash() {
		// replace element data array with a larger empty version
		HashEntry[] oldElementData = elementData;
		elementData = new HashEntry[2 * oldElementData.length];
		size = 0;

		// re-add all of the old data into the new array
		for (int i = 0; i < oldElementData.length; i++) {
			HashEntry current = oldElementData[i];
			while (current != null) {
				add(current.data);
				current = current.next;
			}
		}
	}

	// CHAPTER 18 EXERCISE 1
	// Post: adds all values from parameter set to this set without any duplicates
	public void addAll(HashIntSet s) {
		HashEntry[] hashSet2 = s.elementData;
		for (int i = 0; i < hashSet2.length; i++) {
			if (hashSet2[i] != null) {
				HashEntry current = hashSet2[i];
				while (current != null) { // While this array index has more nodes
					this.add(current.data);
					current = current.next;
				}
			}
		}
	}

	// CHAPTER 18 EXERCISE 2
	// Post: returns true if parameter set's elements are all in this set, false otherwise.
	public boolean containsAll(HashIntSet s) {
		HashEntry[] hashSet2 = s.elementData;
		for (int i = 0; i < hashSet2.length; i++) {
			if (hashSet2[i] != null) {
				if (!this.contains(hashSet2[i].data)) { // If one element is not in, exit immediately since this set does not contain one of set2's elements
					return false;
				}
			}
		}
		return true;
	}

	// CHAPTER 18 EXERCISE 3
	// Post: returns true if parameter set has the same exact elements as this set, order of elements does not matter
	public boolean equals(HashIntSet s) {
		HashEntry[] hashSet2 = s.elementData;
		if (this.size != s.size) { // early return if the sizes arn't the same because different sizes = not equal
			return false;
		}
		for (int i = 0; i < hashSet2.length; i++) {
			if (hashSet2[i] != null) {
				if (!this.contains(hashSet2[i].data)) { // If one element is not in another, then return false since they arn't equal
					return false;
				}
			}
		}
		return true;
	}

	// Represents a single value in a chain stored in one hash bucket.
	private class HashEntry {
		public int data;
		public HashEntry next;

		public HashEntry(int data) {
			this(data, null);
		}

		public HashEntry(int data, HashEntry next) {
			this.data = data;
			this.next = next;
		}
	}
}
