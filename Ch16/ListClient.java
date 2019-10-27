
public class ListClient {
	public static void main(String[] args) {
		LinkedIntList list = new LinkedIntList();
		list.add(10);
		list.add(25);
		list.add(31);
		list.add(47);
		list.add(52);
		list.add(68);
		list.add(77); // ODD LIST
		list.add(88); // EVEN LIST

		System.out.println("CHAPTER 16, EXERCISE 8\n");

		System.out.println("Before switchPairs(): " + list);

		list.switchPairs();

		System.out.println("After switchPairs(): " + list);

		LinkedIntList list2 = new LinkedIntList();

		list2.add(8);
		list2.add(7);
		list2.add(-4);
		list2.add(19);
		list2.add(0);
		list2.add(43);
		list2.add(-8);
		list2.add(-7);
		list2.add(2);

		System.out.println("\nCHAPTER 16, EXERCISE 12\n");

		System.out.println("Before split(): " + list2);
		list2.split();

		System.out.println("After split(): " + list2);
	}
}
