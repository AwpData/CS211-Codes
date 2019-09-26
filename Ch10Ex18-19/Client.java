/*	Name: Trevor Tang
 *  Course: CS211
 * 	Date: September 27, 2019
 * 	Reason: Homework assignment to enhance understanding of chapter 10
 */
public class Client {
	public static void main(String[] args) {

		// EXERCISE 18 CODE
		System.out.println("EXERCISE 18");

		Point p1 = new Point(1, 4);
		Point p2 = new Point(2, 5);

		System.out.println(getResults(p1, p2)); // This prints the results of whether p1 is greater than, equal to, or less than p2

		p1 = new Point(5, 3);
		p2 = new Point(2, 3);

		System.out.println(getResults(p1, p2));

		p1 = new Point(-9, -5);
		p2 = new Point(-11, -5);

		System.out.println(getResults(p1, p2));

		p1 = new Point(1, 2);
		p2 = new Point(1, 2);

		System.out.println(getResults(p1, p2));

		// EXERCISE 19 CODE
		System.out.println("\nEXERCISE 19");

		TimeSpan time1 = new TimeSpan(3, 15);
		TimeSpan time2 = new TimeSpan(2, 18);

		System.out.println(getResults(time1, time2));

		time1 = new TimeSpan(1, 40);
		time2 = new TimeSpan(9, 40);

		System.out.println(getResults(time1, time2));

		time1 = new TimeSpan(5, 32);
		time2 = new TimeSpan(5, 32);

		System.out.println(getResults(time1, time2));
	}

	public static String getResults(Point p1, Point p2) { // gets results for point objects
		int compareToResult = p1.compareTo(p2);
		System.out.println("\nComparing " + p1 + " to " + p2);
		System.out.println("p1.compareTo(p2) returns " + compareToResult);
		if (compareToResult > 0) {
			return p1 + " is greater than " + p2;
		} else if (compareToResult < 0) {
			return p1 + " is less than " + p2;
		} else {
			return p1 + " is equal to " + p2;
		}
	}

	public static String getResults(TimeSpan time1, TimeSpan time2) { // gets results for timespan objects
		int compareToResult = time1.compareTo(time2);
		System.out.println("\nComparing " + time1 + " to " + time2);
		System.out.println("time1.compareTo(time2) returns " + compareToResult);
		if (compareToResult > 0) {
			return time1 + " is greater than " + time2;
		} else if (compareToResult < 0) {
			return time1 + " is less than " + time2;
		} else {
			return time1 + " is equal to " + time2;
		}
	}
}

