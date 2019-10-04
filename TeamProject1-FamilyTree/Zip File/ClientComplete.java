import java.io.*;
import java.util.*;

public class ClientComplete {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		Scanner fileReader = new Scanner(new File("src/people.txt")); // Remove src later!!!
		boolean programRunning = true;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Person> familyStructures = new ArrayList<Person>();
		ArrayList<Person> people = new ArrayList<Person>();
		String person = "", mother = "", father = "";

		while (fileReader.hasNextLine()) { // Makes ArrayList of all family members
			String name = fileReader.nextLine();
			if (name.equals("END")) {
				break;
			} else {
				names.add(name);
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
			people.add(p);
		}

		System.out.println("Welcome to the family tree program");
		while (programRunning) { // USER INPUTS
			System.out.println("\nWhat would you like to do? (Enter #)");
			System.out.println("1. Print all tudor family members");
			System.out.println("2. Print family tree of a certain person");
			System.out.println("3. Quit program");
			String selection = input.nextLine();

			if (selection.equals("1")) {
				for (int i = 0; i < names.size(); i++) {
					System.out.println(names.get(i)); // Prints every family member in names arraylist
				}

			} else if (selection.equals("2")) {
				for (int i = 0; i < names.size(); i++) {
					System.out.println(names.get(i));
				}
				System.out.print("\nWhat is the Person's name?: ");
				String name = input.nextLine(); // Gets the name of the family member
				System.out.println("\nPerson:\n" + name);
				for (int j = 0; j < people.size(); j++) {
					if (people.get(j).getPerson().equalsIgnoreCase(name)) { // If the person exists...
						System.out.println("\nMaternal line: ");
						System.out.println("\t" + people.get(j).getPerson()); // Prints their name first
						System.out.println("\t\t" + people.get(j).getMother()); // Then the mothers
						System.out.println("\nPaternal line: ");
						System.out.println("\t" + people.get(j).getPerson());
						System.out.println("\t\t" + people.get(j).getFather()); // Does the same thing except it prints the fathers here
						break;
					} else if (j == people.size() - 1) { // if the person has no record of a mother or father they are listed as unknown
						System.out.println("\nMaternal line: ");
						System.out.println("\t" + name);
						System.out.println("\t\tUnknown");
						System.out.println("\nPaternal line: ");
						System.out.println("\t" + name);
						System.out.println("\t\tUnknown");
					}
				}
				System.out.println("\nChildren:");
				int numberOfChildren = 0;
				for (int k = 0; k < people.size(); k++) {
					if (people.get(k).getMother().equalsIgnoreCase(name) || people.get(k).getFather().equalsIgnoreCase(name)) { // If the person is their father
						numberOfChildren++;
						System.out.println(people.get(k).getPerson());
					} else if (k == people.size() - 1 && numberOfChildren == 0) { // If the person has no children
						System.out.println("Unknown");
					}
				}

			} else if (selection.equals("3")) { // Quits the program
				System.out.println("Quitting program...");
				System.exit(0); // Found in java API 8 under System class methods (instantly terminates the program)
			}
		}
	}
}
