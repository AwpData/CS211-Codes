
/* Name: Trevor Tang
 * Course: CS 211
 * Date: October 6, 2019 
 * Reason: To enhance understanding of how set and iterators work in java  
 */

import java.util.*;

public class CH11Ex11 {
	public static void main(String[] args) {
		Set<Integer> set1 = new TreeSet<Integer>();
		Set<Integer> set2 = new TreeSet<Integer>();
		Set<Integer> set3 = new TreeSet<Integer>();
		for (int i = 0; i <= 10; i++) { // Adds all numbers 1-10 to set1
			set1.add(i);
			if (i % 2 == 0) { // Adds even numbers to set2
				set2.add(i);
			}
			if (i % 2 == 1) { // Adds odd numbers to set3
				set3.add(i);
			}
		}
		System.out.println("Set 1 contains: " + set1);
		System.out.println("Set 2 contains: " + set2);
		Set<Integer> newSet = symmetricSetDifference(set1, set2);
		System.out.println("The different numbers in these sets are: " + newSet);

		System.out.println("\nSet 1 contains: " + set1);
		System.out.println("Set 3 contains: " + set3);
		Set<Integer> newSet2 = symmetricSetDifference(set1, set3);
		System.out.println("The different numbers in these sets are: " + newSet2);
	}

	public static Set<Integer> symmetricSetDifference(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> newSet = new TreeSet<>(); // Creates a new set for the different numbers
		Iterator<Integer> iteratorSet1 = set1.iterator(); // New iterator object for set1
		while (iteratorSet1.hasNext()) {
			int num = iteratorSet1.next(); // Gets the next num in set1
			if (!set2.contains(num)) { // If set2 doesn't have this num in set1
				newSet.add(num); // Add it to the new set
			}
		}
		return newSet;
	}
}
