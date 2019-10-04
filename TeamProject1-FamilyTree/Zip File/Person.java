/* Names: Trevor Tang, Sudhanva Donakonda, Anas Gherfal, Hacer Aynur Sari
 * Course: CS 211
 * Date: October 4, 2019
 * Reason: To store a person's name, their mother, and their father with getter methods 
 */

public class Person {
	private String mother, father, person;

	public Person(String person, String mother, String father) {
		this.person = person;
		this.mother = mother;
		this.father = father;
	}

	public String getPerson() {
		return this.person;
	}

	public String getMother() {
		return this.mother;
	}

	public String getFather() {
		return this.father;
	}
}
