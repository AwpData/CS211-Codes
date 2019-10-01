import java.io.*;
import java.util.*;

public class Client {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		Scanner fileReader = new Scanner(new File("src/people.txt"));
		boolean programRunning = true;
		ArrayList<String> printableFamilyNames = new ArrayList<String>();
		ArrayList<Person> familyStructures = new ArrayList<Person>();
		ArrayList<Person> dataFamilyNames = new ArrayList<Person>();
		String person = "", mother = "", father = "";

		while (fileReader.hasNextLine()) { // Makes ArrayList of all family members
			String name = fileReader.nextLine();
			if (name.equals("END")) {
				break;
			} else {
				printableFamilyNames.add(name);
			}
		}

		while (fileReader.hasNextLine()) { // makes ArrayList of all family trees to be used later
			person = fileReader.nextLine();
			if (person.equals("END")) {
				break;
			}
			mother = fileReader.nextLine();
			if (mother.equals("END")) {
				break;
			}
			father = fileReader.nextLine();
			if (father.equals("END")) {
				break;
			}
			Person p = new Person(person, mother, father);
			familyStructures.add(p);
			dataFamilyNames.add(p);
		}

		System.out.println("Welcome to the family tree program");
		while (programRunning) {
			System.out.println("\nWhat would you like to do? (Enter #)");
			System.out.println("1. Print all family members");
			System.out.println("2. Print family tree of a certain member");
			System.out.println("3. Quit program");
			String selection = input.nextLine();

			if (selection.equals("1")) {
				for (int i = 0; i < printableFamilyNames.size(); i++) {
					System.out.println(printableFamilyNames.get(i));
				}

			} else if (selection.equals("2")) {
				for (int i = 0; i < printableFamilyNames.size(); i++) {
					System.out.println(i + ". " + printableFamilyNames.get(i));
				}
				System.out.println("\nEnter the number of the family member");
				int nameNumber = input.nextInt();
				String name = printableFamilyNames.get(nameNumber);
				System.out.println("Person:\n" + name);
				for (int j = 0; j < dataFamilyNames.size(); j++) {
					if (dataFamilyNames.get(j).getPerson().equalsIgnoreCase(name)) {
						System.out.println("\nMother:\n" + dataFamilyNames.get(j).getMother());
						System.out.println("\nFather:\n" + dataFamilyNames.get(j).getFather());
						break;
					} else if (j == dataFamilyNames.size() - 1) {
						System.out.println("\nMother: Unknown");
						System.out.println("\nFather: Unknown");
					}
				}
				System.out.println("\nChildren:");
				int numberOfChildren = 0;
				for (int k = 0; k < dataFamilyNames.size(); k++) {
					if (dataFamilyNames.get(k).getFather().equalsIgnoreCase(name)) {
						numberOfChildren++;
						System.out.println(dataFamilyNames.get(k).getPerson());
					} else if (k == dataFamilyNames.size() - 1 && numberOfChildren == 0) {
						System.out.println("Unknown");
					}
				}
				input.nextLine();

			} else if (selection.equals("3")) {
				System.out.println("Quitting program...");
				System.exit(0);
			}
		}
	}
}
