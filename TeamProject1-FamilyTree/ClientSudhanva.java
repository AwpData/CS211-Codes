import java.util.*;
import java.io.*;

public class ClientSudhanva {
	public static void main(String[] args) throws FileNotFoundException {

		String file = "C:\\Users\\Sudhanva Donakonda\\Downloads\\tudor.txt\\";
		Scanner input = new Scanner(new File(file));
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> family = new ArrayList<String>();
		ArrayList<Person> people = new ArrayList<Person>();

		while (input.hasNextLine()) {
			String n = input.nextLine();
			names.add(n);
		}
		for (int i = names.indexOf("END") + 2; i < names.size(); i++) {
			family.add(names.get(i));
			names.remove(i);
			i--;

		}
		for (int i = 0; i < family.size() - 1; i++) {

			String son = family.get(i);
			String mom = family.get(i + 1);
			String dad = family.get(i + 2);
			people.add(new Person(son, mom, dad));
			i = i + 2;

		}

		Scanner input1 = new Scanner(System.in);
		String person = "";
		while (!person.equals("QUIT")) {
			System.out.print("What is the Person's name ");
			person = input1.nextLine();
			String children = "";
			for (int i = 0; i < people.size(); i++) {
				if (people.get(i).getPerson().equals(person)) {
					System.out.println("Maternal line: ");
					System.out.println(" " + people.get(i).getPerson());
					System.out.println(" " + people.get(i).getMother());
					System.out.println("Paternal line: ");
					System.out.println(" " + people.get(i).getPerson());
					System.out.println(" " + people.get(i).getFather());
				}
				if (people.get(i).getMother().equals(person) || people.get(i).getFather().equals(person)) {
					children += people.get(i).getPerson() + "\n";

				}

			}
			System.out.println("Children: " + "\n" + children);

		}
	}
}
