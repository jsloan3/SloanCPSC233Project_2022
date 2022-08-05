package application;

public class Person {
	
	private double beforeTaxIncome;
	private String name;
	private Tax taxes;

	public Person(String personName) {
		this.setName(personName);
	}
	
	private void setTaxProvince(String residence) {
		this.taxes = new Tax(residence);
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
