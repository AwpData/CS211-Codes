// Name: Trevor Tang
// Course: CS 211
// Date: October 22, 2019
// Reason: Client code to test exercises 1, 2, 5, 8, and 11 

public class Client {
	public static void main(String[] args) {
		// Creates ArrayList of [1, 18, 2, 7, 18, 39, 18, 40]
		ArrayListPlus<Integer> a = new ArrayListPlus<>();
		a.add(1);
		a.add(18);
		a.add(2);
		a.add(7);
		a.add(18);
		a.add(39);
		a.add(18);
		a.add(40);

		// EXERCISE 1 TESTS
		System.out.println("***EXERCISE 1: lastIndexOf() test:");
		System.out.println(a);
		System.out.println("Last index of 18: " + a.lastIndexOf(18));
		System.out.println("Last index of 0: " + a.lastIndexOf(0) + "\n");

		// EXERCISE 2 TESTS
		System.out.println("***EXERCISE 2: indexOfSubList() test:");
		ArrayListPlus<Integer> a2 = new ArrayListPlus<>();
		a2.add(18);
		a2.add(2);
		a2.add(7);
		System.out.println("ORIGINAL LIST: " + a);
		System.out.println("SECOND LIST: " + a2.toString());
		System.out.println("Index of a2: " + a.indexOfSubList(a2) + "\n");
		
		a2.clear();
		a2.add(7);
		a2.add(18);
		a2.add(39);
		System.out.println("ORIGINAL LIST: " + a);
		System.out.println("SECOND LIST: " + a2.toString());
		System.out.println("Index of a2: " + a.indexOfSubList(a2) + "\n");
		
		a2.clear();
		a2.add(2);
		a2.add(18);
		a2.add(7);
		System.out.println("ORIGINAL LIST: " + a);
		System.out.println("SECOND LIST: " + a2.toString());
		System.out.println("Index of a2: " + a.indexOfSubList(a2) + "\n");

		// EXERCISE 5 TEST
		System.out.println("***EXERCISE 5: runningTotal() test:");
		System.out.println("Original list: " + a);
		ArrayListPlus<Integer> a5 = a.runningTotal();
		System.out.println("Running total of original list: " + a5 + "\n");

		// EXERCISE 8 TEST
		System.out.println("***EXERCISE 8: count() test:");
		System.out.println(a);
		System.out.println("Number of 18's in list: " + a.count(18));
		System.out.println("Number of 0's in list: " + a.count(0) + "\n");

		// EXERCISE 11 TEST
		System.out.println("***EXERCISE 11: removeLast() test:");
		System.out.println(a);
		while (a.size() > 0) {
			int num = a.removeLast();
			System.out.println("Removed: " + num);
			System.out.println(a);
		}
	}
}
