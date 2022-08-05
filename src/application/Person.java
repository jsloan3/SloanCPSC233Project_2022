package application;

public class Person {
	
	private double beforeTaxIncome;
	private String name;
	private Tax taxes;

	public Person(String personName) {
		this.setName(personName);
	}
	
	private int setTaxProvince(String residence) {
		if (residence.equals("Alberta")) {
			this.taxes = new AlbertaTax();
			return 1;
		} else {
			return 0;
		}
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
