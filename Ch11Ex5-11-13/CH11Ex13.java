import java.util.*;

public class CH11Ex13 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		map.put("Trevor", "Tang");
		map.put("Travis", "Teng");
		map.put("Trey", "Tong");
		map2.put("Trevor", "Tang");
		map2.put("Travis", "Teng");
		map2.put("Trey", "Tang");

		System.out.println("Map1: " + map + " returns: " + isUnique(map)); // Returns TRUE because all have different values
		System.out.println("Map2: " + map2 + " returns: " + isUnique(map2)); // Returns FALSE because two "Tang" values
	}

	public static boolean isUnique(Map<String, String> map) {
		ArrayList<String> compare = new ArrayList<>(); // Create a list so that the values can be compared later
		for (String key : map.keySet()) {
			compare.add(map.get(key)); // Adds every value to the list
		}
		for (int i = 0; i < compare.size() - 1; i++) {
			String focusedName = compare.get(i); // Gets the name
			for (int j = i + 1; j < compare.size(); j++) {
				if (compare.get(j).equals(focusedName)) { // If there is another instance of the value name
					return false;
				}
			}
		}
		return true;
	}
}
