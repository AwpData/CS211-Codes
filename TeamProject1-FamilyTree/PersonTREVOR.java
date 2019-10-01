
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
	
	public String toString() {
		return this.getPerson();
	}
	
}
