import java.util.*;

public class CH11Ex05 {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int num = (int) ((int) 1 + Math.random() * 100); // Random numbers each execution in list
			numbers.add(num);
			numbers.add(num); // This is here so that the list has duplicates
		}
		System.out.println("Before sorting and with duplicates: " + numbers);
		Set<Integer> sortedNumbers = sortAndRemoveDuplicates(numbers);
		System.out.println("After sorting and duplicates removed: " + sortedNumbers);
	}

	public static Set<Integer> sortAndRemoveDuplicates(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) { // Removes all duplicates
			int num = list.get(i); // Gets the number at this index
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) == num) { // If this number at index j equals num
					list.remove(list.get(j)); // Remove it
				}
			}
		}
		Set<Integer> sortedSet = new TreeSet<>(list); // Since TreeSets automatically sort in natural order
		return sortedSet;
	}
}
