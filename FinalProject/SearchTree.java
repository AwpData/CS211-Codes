import java.util.Arrays;

// This class stores int values in a binary search tree.
// Duplicates are allowed.  Each node of the tree has the binary
// search tree property.

public class SearchTree<E> implements Comparable<E> {
	private TreeNode overallRoot;
	private Object[] array;
	
	// post: constructs an empty tree
	public SearchTree() {
		overallRoot = null;
		array = null;
	}

	// post: value is added to overall tree so as to preserve the
	// binary search tree property
	public void add(Comparable<E> value) {
		overallRoot = add(overallRoot, value);
	}

	// post: value is added to given tree so as to preserve the
	// binary search tree property
	private TreeNode add(TreeNode root, Comparable<E> value) {
		if (root == null) {
			root = new TreeNode((E) value);
		} else if (value.compareTo(root.data) < 0) {
			root.left = add(root.left, value);
		} else if (value.compareTo(root.data) > 0) {
			root.right = add(root.right, value);
		}
		this.array = this.toArray();
		return root;
	}

	// Class for storing a single node of a binary tree of ints

	public class TreeNode {
		public E data;
		public TreeNode left;
		public TreeNode right;

		// constructs a leaf node with given data
		public TreeNode(E data) {
			this(data, null, null);
		}

		// constructs a branch node with given data, left subtree,
		// right subtree
		public TreeNode(E data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public E getNode() {
			return this.data;
		}
	}

	// post: returns true if overall tree contains value
	public boolean contains(Comparable<E> value) {
		return contains(overallRoot, value);
	}

	// post: returns true if given tree contains value
	private boolean contains(TreeNode root, Comparable<E> value) {
		if (root == null) {
			return false;
		} else if (value.compareTo(root.data) == 0) {
			return true;
		} else if (value.compareTo(root.data) < 0) {
			return contains(root.left, value);
		} else { // value > root.data
			return contains(root.right, value);
		}
	}

	// post: counts the nodes of the tree via inorder traversal
	// and returns the count
	public int countNodes() {
		return countNodes(overallRoot);
	}

	// post: returns the node count using an inorder traversal
	// using the given root
	private int countNodes(TreeNode root) {
		if (root != null) {
			return 1 + countNodes(root.left) + countNodes(root.right);
		} else {
			return 0;
		}
	}

	// post: prints the tree contents, one per line, following an
	// inorder traversal and using indentation to indicate
	// node depth; prints right to left so that it looks
	// correct when the output is rotated.
	public void printSideways() {
		printSideways(overallRoot, 0);
	}

	// post: prints in reversed preorder the tree with given
	// root, indenting each line to the given level
	private void printSideways(TreeNode root, int level) {
		if (root != null) {
			printSideways(root.right, level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("    ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	}

	// Added methods below

	public void addAll(SearchTree<E> tree) {
		addAll(tree.overallRoot);
		this.array = this.toArray();
	}

	private void addAll(TreeNode root) {
		if (root != null) {
			this.add((Comparable<E>) root.data);
			addAll(root.left);
			addAll(root.right);
		}
	}

	public void clear() {
		this.overallRoot = null;
	}

	public boolean containsAll(SearchTree<E> tree) {
		Object[] array = tree.toArray();
		for (int i = 0; i < array.length; i++) {
			if (!this.contains((Comparable<E>) array[i])) {
				return false;
			}
		}
		return true;
	}

	public boolean isEmpty() {
		return overallRoot == null;
	}

	// Pre: overallRoot != null
	// Post: Tree has object o removed from it, returns true if it found that object in tree, false otherwise
	public boolean remove(Object o) { // A pretty creative remove method
		if (overallRoot == null) { // Checks to make sure there is a value in the tree
			throw new IllegalArgumentException("No values in tree");
		}
		Object[] array = this.toArray(); // Use array for easier removals

		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(o)) { // If this element equals the element we want to remove
				swap(array, i, 0); // Initially brings the removed value to the top of the tree to be removed by swapping it with the top value
				Object[] adjustedArray = Arrays.copyOf(array, array.length - 1); // Makes a copy of the tree with length - 1 which removes the value

				for (int j = 0; j < adjustedArray.length; j++) {
					adjustedArray[j] = array[j + 1]; // Then it adjusts the array by getting every value after the removed value and adding it
				}

				if (i != 0) { // Then if the value removed wasn't the top value it will swap the value we swapped earlier back to the top
					swap(adjustedArray, i - 1, 0);
				}

				if (adjustedArray.length > 0) { // If the new array has a length greater than 0
					overallRoot = new TreeNode((E) adjustedArray[0]); // Set the tree to first equal to the top value
					for (int k = 1; k < array.length; k++) { // Then we just add each element back from the original array minus the removed element
						this.add((Comparable<E>) array[k]); // Restores the original tree order with the given element removed
					}
					this.array = this.toArray(); // Updates our array
					return true;

				} else { // If there is nothing left in the array then set the tree to null
					this.array = this.toArray(); // Updates our array
					overallRoot = null; // There is nothing there anymore so set it to null
					return true;
				}
			}
		}
		return false; // returns false if value is not found in array
	}

	private void swap(Object[] array, int indexOldValue, int indexNewValue) {
		Object temp = array[indexOldValue];
		array[indexOldValue] = array[indexNewValue];
		array[indexNewValue] = temp;

	}

	public void removeAll(SearchTree<E> tree) {
		Object[] array = tree.toArray();
		for (Object o : array) {
			if (this.contains((Comparable<E>) o)) {
				this.remove(o);
			}
		}
	}

	public void retainAll(SearchTree<E> tree) {
		Object[] thisArray = this.toArray();
		for (int i = 0; i < thisArray.length; i++) {
			if (!tree.contains((Comparable<E>) thisArray[i])) {
				this.remove(thisArray[i]);
			}
		}
	}

	public Object[] toArray() {
		return toArray(overallRoot, 0, new Object[this.countNodes()]);
	}

	private Object[] toArray(TreeNode root, int index, Object[] array) { // Array is made with inorder traversal of tree
		if (root != null) {
			while (array[index] != null) { // Keeps looking for an empty spot in the array
				index++;
			}
			array[index] = root.data;
			index++;
			toArray(root.left, index, array);
			toArray(root.right, index, array);
			return array;
		}
		return null;
	}

	public String toString() { // Helper Method to print an array in an inorder traversal to represent the binary tree
		Object[] array = this.toArray();
		String s = "[";
		if (array != null && array.length > 0) {
			s = "[" + array[0];
			for (int i = 1; i < array.length; i++) {
				if (array[i] == null) {
					break;
				} else {
					s += ", " + array[i];
				}
			}
		}
		s += "]";
		return s;
	}

	public int compareTo(E object) {
		if (this.compareTo(object) > 0) {
			return 1;
		} else if (this.compareTo(object) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
