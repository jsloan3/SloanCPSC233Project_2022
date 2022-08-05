package application;

public class Person {
	
	private double beforeTaxIncome;
	private String name;

	public Person(String personName) {
		this.setName(personName);
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
