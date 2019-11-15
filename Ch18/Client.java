/* Name: Trevor Tang
 * Course: CS 211
 * Date: November 17, 2019
 * Reason: Client code to showcase Chapter 18 exercises 
 */

public class Client {
	public static void main(String[] args) {

		// ----------- EXERCISE 1 -------------- //
		HashIntSet set = new HashIntSet();
		set.add(1);
		set.add(21);
		set.add(31);
		set.add(41);
		set.add(2);

		HashIntSet set2 = new HashIntSet();
		set2.add(-5);
		set2.add(1);
		set2.add(2);
		set2.add(3);

		System.out.println("------- EXERCISE 1 TEST -------");
		System.out.println("\nHashSet: " + set);
		System.out.println("HashSet2: " + set2 + "\n");

		System.out.println("Before addAll(): HashSet = " + set + ", size " + set.size());
		System.out.println("Adding HashSet2 to HashSet");
		set.addAll(set2);
		System.out.println("After addAll(): HashSet = " + set + ", size " + set.size());

		// ------------- EXERCISE 2 & EXERCISE 3 -------------- //
		HashIntSet set3 = new HashIntSet();

		set3.add(1);
		set3.add(21);
		set3.add(31);
		set3.add(41);
		set3.add(2);

		HashIntSet set4 = new HashIntSet();

		set4.add(41);
		set4.add(31);
		set4.add(21);
		set4.add(2);
		set4.add(1);

		System.out.println("\n------- EXERCISE 2 TEST -------");
		System.out.println("\nHashSet3: " + set3);
		System.out.println("HashSet4: " + set4 + "\n");

		System.out.println("Does HashSet3 contain all elements from HashSet4? " + set3.containsAll(set4));

		System.out.println("Is HashSet3 equal to HashSet4? " + set3.equals(set4));

		// ------- EXERCISE 9 & EXERCISE 10 -------- //

		HeapIntPriorityQueue q = new HeapIntPriorityQueue();
		q.add(42);
		q.add(50);
		q.add(45);
		q.add(78);
		q.add(61);

		System.out.println("\n------- EXERCISE 9 TEST -------");
		System.out.println("\nHeapPriorityQueue: " + q);
		System.out.println("\nBefore kthSmallest(): " + q);
		System.out.println("The 4th smallest element is: " + q.kthSmallest(q, 4));
		System.out.println("After kthSmallest(): " + q);

		HeapIntPriorityQueue q2 = new HeapIntPriorityQueue();
		q2.add(42);
		q2.add(53);
		q2.add(42);
		q2.add(78);
		q2.add(61);
		q2.add(42);
		q2.add(53);
		q2.add(42);
		q2.add(78);
		q2.add(61);

		System.out.println("\n------- EXERCISE 10 TEST -------");

		System.out.println("\nHeapPriorityQueue2: " + q2);
		System.out.println("\nBefore removeDuplicates(): " + q2);
		q2.removeDuplicates(q2);
		System.out.println("After removeDuplicates(): " + q2);
	}
}
