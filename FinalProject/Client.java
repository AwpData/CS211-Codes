import java.util.Arrays;

public class Client {
	public static void main(String[] args) {

		SearchTree<Integer> tree = new SearchTree<>();
		tree.add(10);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(14);
		tree.add(13);
		tree.add(15);
		tree.add(16);
		tree.add(1);

		System.out.println("\n--------- toArray() test ---------\n");
		tree.printSideways();
		System.out.println("\nSetting the above tree to an array");
		Object[] array = tree.toArray(); // In inorder form
		System.out.println("Tree array: " + Arrays.deepToString(array));

		System.out.println("\n--------- remove() Test ------------\n");
		System.out.println("tree before removing any elements: " + tree + "\n");
		tree.printSideways();
		System.out.println("\nTrying to remove 3. Success?: " + tree.remove(3));
		System.out.println("Trying to remove 5. Success?: " + tree.remove(5));
		System.out.println("Trying to remove 10. Success?: " + tree.remove(10));
		System.out.println("tree after remove methods called: " + tree + "\n");
		tree.printSideways();

		SearchTree<Integer> tree2 = new SearchTree<>();
		tree2.add(13);
		tree2.add(15);
		tree2.add(5);
		tree2.add(1);
		tree2.add(6000);

		System.out.println("\n-------- retainAll() test ---------\n");
		System.out.println("tree before retainAll: " + tree);
		System.out.println("tree2: " + tree2);
		tree.retainAll(tree2);
		System.out.println("tree after retaining all elements found in tree2: " + tree + "\n");
		tree.printSideways();

		SearchTree<Integer> tree3 = new SearchTree<>();
		tree3.add(10);
		tree3.add(2);
		tree3.add(3);
		tree3.add(4);
		tree3.add(14);
		tree3.add(16);
		tree3.add(15);
		tree3.add(19);
		tree3.add(1);

		SearchTree<Integer> tree4 = new SearchTree<>();
		tree4.add(1);
		tree4.add(16);
		tree4.add(2);
		tree4.add(14);

		SearchTree<Integer> addingTree = new SearchTree<>();
		addingTree.add(7);
		addingTree.add(8);
		addingTree.add(21);

		System.out.println("\n---------- containsAll() test ------------\n");
		System.out.println("tree3: " + tree3);
		System.out.println("tree4: " + tree4);
		System.out.println("Does tree3 contain all elements from tree4?: " + tree3.containsAll(tree4));
		System.out.println("Does tree4 contian all elements from tree3?: " + tree4.containsAll(tree3));

		System.out.println("\n---------- addAll() test ----------\n");
		System.out.println("tree3 before addAll method: " + tree3 + "\n");
		tree3.printSideways();
		System.out.println("\naddingTree: " + addingTree);
		System.out.println("Adding all elements from addingTree to tree3");
		tree3.addAll(addingTree);
		System.out.println("tree3 after addAll: " + tree3 + "\n");
		tree3.printSideways();

		SearchTree<String> tree5 = new SearchTree<>();
		tree5.add("Homer");
		tree5.add("Bart");
		tree5.add("Lisa");
		tree5.add("Maggie");
		tree5.add("Burns");
		tree5.add("Skinner");

		SearchTree<String> tree6 = new SearchTree<>();

		tree6.add("Lisa");
		tree6.add("Burns");
		tree6.add("Bart");
		tree6.add("Skinner");

		System.out.println("\n---------- removeAll() test -----------\n");
		System.out.println("tree5 before removeAll method: " + tree5 + "\n");
		tree5.printSideways();
		System.out.println("\ntree6: " + tree6);
		tree5.removeAll(tree6);
		System.out.println("tree5 after removing all elements found in tree6: " + tree5 + "\n");
		tree5.printSideways();

		System.out.println("\n---------- clear() test -----------\n");
		System.out.println("tree6 before clear method: " + tree6 + "\n");
		tree6.printSideways();
		tree6.clear();
		System.out.println("\ntree6 after clearing: " + tree6);
		tree6.printSideways(); // Will output nothing since there is nothing in tree

		System.out.println("\n---------- isEmpty() test -----------\n");
		System.out.println("Is tree6 empty?: " + tree6.isEmpty());
		System.out.println("\nAdding Cletus to tree6\n");
		tree6.add("Cletus");
		System.out.println("tree6 after add: " + tree6);
		System.out.println("Is tree6 empty?: " + tree6.isEmpty());

		System.out.println("\n---------- END OF PROGRAM ------------");
	}
}
