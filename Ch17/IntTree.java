/* Name: Trevor Tang
 * Course: CS211
 * Date: November 10, 2019
 * Reason: IntTree class that has methods for exercises 1, 5, and 8
 */

public class IntTree {
	private IntTreeNode overallRoot;

	// pre : max > 0
	// post: constructs a sequential tree with given number of
	// nodes
	public IntTree(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("max: " + max);
		}
		overallRoot = buildTree(1, max);
	}

	// post: returns a sequential tree with n as its root unless
	// n is greater than max, in which case it returns an
	// empty tree
	private IntTreeNode buildTree(int n, int max) {
		if (n > max) {
			return null;
		} else {
			return new IntTreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
		}
	}

	public class IntTreeNode { // Inner class IntTreeNode
		public int data;
		public IntTreeNode left;
		public IntTreeNode right;

		// constructs a leaf node with given data
		public IntTreeNode(int data) {
			this(data, null, null);
		}

		// constructs a branch node with given data, left subtree,
		// right subtree
		public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public int getNode() {
			return this.data;
		}
	}

	// post: prints the tree contents using a preorder traversal
	public void printPreorder() {
		System.out.print("preorder:");
		printPreorder(overallRoot);
		System.out.println();
	}

	// post: prints the tree contents using a preorder traversal
	// post: prints in preorder the tree with given root
	private void printPreorder(IntTreeNode root) {
		if (root != null) {
			System.out.print(" " + root.data);
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}

	// post: prints the tree contents using a inorder traversal
	public void printInorder() {
		System.out.print("inorder:");
		printInorder(overallRoot);
		System.out.println();
	}

	// post: prints in inorder the tree with given root
	private void printInorder(IntTreeNode root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(" " + root.data);
			printInorder(root.right);
		}
	}

	// post: prints the tree contents using a postorder traversal
	public void printPostorder() {
		System.out.print("postorder:");
		printPostorder(overallRoot);
		System.out.println();
	}

	// post: prints in postorder the tree with given root
	private void printPostorder(IntTreeNode root) {
		if (root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(" " + root.data);
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
	private void printSideways(IntTreeNode root, int level) {
		if (root != null) {
			printSideways(root.right, level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("    ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	}

	// CHAPTER 17, EXERCISE 1
	public int countLeftNodes() {
		return countLeftNodes(overallRoot);
	}

	private int countLeftNodes(IntTreeNode root) { // Helper method for exercise 1
		if (root == null) { // if the right branch is null, simply return 0
			return 0;
		}
		if (root.left != null) { // If there is a left branch then use recursion to get the total number of left branches (+1 each left node), and any that appear in the right branches
			return 1 + countLeftNodes(root.left) + countLeftNodes(root.right);
		} else {
			return countLeftNodes(root.right); // else if there is no left branch keep going right (as there many be left branches farther down the tree)
		}
	}

	// CHAPTER 17, EXERCISE 5
	public void printLevel(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n must be greater than 1");
		} else {
			printLevel(overallRoot, n, 1);
		}
	}

	private void printLevel(IntTreeNode root, int level, int currentLevel) { // Helper method for exercise 5
		if (root != null) { // First check this root is not null
			if (currentLevel < level) { // Since we start at the overall root at level 1, if this level is not equal to the client level
				printLevel(root.left, level, currentLevel + 1); // Go one more level on left branch
				printLevel(root.right, level, currentLevel + 1); // Go one more level on right branch
			} else { // If we are at the right level then print the data there and stop
				System.out.println(root.data);
			}
		}
	}

	// CHAPTER 17, EXERCISE 8

	public String toString() {
		if (overallRoot == null) {
			return "empty";
		} else {
			String s = overallRoot.data + "";
			return toString(overallRoot.left, s) + toString(overallRoot.right, "");
			/*
			 * To fix comma fencepost bug, I put the root data as the first thing in the string. Then since this method will traverse in a preorder traversal, I would put all the branches of the left side first to the returned string. Then I would add on lastly on the String the right side of the tree.
			 */
		}

	}

	private String toString(IntTreeNode root, String s) { // Helper method for exercise 8
		if (root != null) {
			s += ", " + root.data; // If root isn't null add this data value to our string
			if (root.right == null && root.left == null) { // If both left and right branches are null return the string
				return s;
			} else { // else if both branches or just one of them have a value in it
				s = toString(root.left, s);
				s = toString(root.right, s);
			}
		} else { // If one of the branches is null it will say that it is empty
			s += ", empty";
		}
		return s;
	}
}
