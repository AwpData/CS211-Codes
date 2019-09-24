
/* Name: Trevor Tang
 * Class: CS 211
 * Date: September 24, 2019
 * Reason: Completing the in class exercise for homework 
 */

import java.util.*;
import java.io.*;

public class ArrayListInt {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner input = new Scanner(new File("numbers.txt"));
		while (input.hasNextInt()) {
			int n = input.nextInt();
			numbers.add(n);
		}
		System.out.println(numbers);
		System.out.println("\nThe average of all the numbers in the list is: " + findAverage(numbers));
		System.out.println("The highest number in this list is: " + highestNumber(numbers));
		System.out.println("The lowest number in this list is: " + lowestNumber(numbers));
		filterEvens(numbers);
		System.out.println("\nNumbers list after evens are filtered out: ");
		System.out.println(numbers);
	}

	// Calculates the average of all numbers in list
	public static double findAverage(ArrayList<Integer> list) {
		double average = 0;
		for (Integer num : list) {
			average += num;
		}
		average /= list.size();
		return average;
	}

	// Finds the highest number by comparing a number in the list with all other numbers, if there is a higher number, the rest of the list compares to that number
	public static int highestNumber(ArrayList<Integer> list) {
		int highestNumber = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			highestNumber = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) > highestNumber) {
					highestNumber = list.get(j);
				}
			}
		}
		return highestNumber;
	}

	// Finds the lowest number by comparing a number in the list with all other numbers, if there is a lower number, the rest of the list compares to that number
	public static int lowestNumber(ArrayList<Integer> list) {
		int lowestNumber = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			lowestNumber = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) < lowestNumber) {
					lowestNumber = list.get(j);
				}
			}
		}
		return lowestNumber;
	}

	// Removes all elements with even values from the given list.
	public static void filterEvens(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			int n = list.get(i);
			if (n % 2 == 0) {
				list.remove(i);
			}
		}
	}
}
