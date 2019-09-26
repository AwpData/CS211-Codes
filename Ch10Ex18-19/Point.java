// A Point object represents a pair of (x, y) coordinates.

public class Point implements Comparable<Point> {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point other) { // Compares this.point to the point given in parameters
		if (this.y == other.y) { // If the y's are the same then compare the x's
			if (this.x < other.x) {
				return -1;
			} else if (this.x > other.x) {
				return 1;
			}
		} else if (this.y < other.y) {
			return -1;
		} else if (this.y > other.y) {
			return 1;
		} // Else if the points are the same
		return 0;
	}

	public String toString() { // toString method for printing
		return "(" + this.x + "," + this.y + ")";
	}
}
