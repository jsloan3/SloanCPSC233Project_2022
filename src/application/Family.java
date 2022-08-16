package application;

import java.util.ArrayList;

public class Family {
	
	private ArrayList<Person> peopleList;
	
	public Family() {
		this.clearPeopleList();
	}
	
	public String checkFamilyAmount(String familyMemberAmountStr) {
		boolean isError = false;
		for (int i = 0; i < familyMemberAmountStr.length(); i++) {
			if (!Character.isDigit(familyMemberAmountStr.charAt(i))) {
				isError = true;
				break;
			}
		}
		
		if (!isError) {
			return "";
		} else {
			return "ERROR: Invalid Family Member # input: " + familyMemberAmountStr + ". Should be an integer.";
		}
	}
	
	/** 
	 * Creates a fresh new ArrayList and uses a setter method to replace the old peopleList.
	 */
	public void clearPeopleList() {
		this.setPeopleList(new ArrayList<Person>());
	}
	
	public double getFamilyAfterTaxesIncome() {
		double totalAfterTaxes = 0.0;
		for (int i = 0; i < this.getPeopleList().size(); i++) {
			totalAfterTaxes += this.getPeopleList().get(i).getTaxes().getAfterTaxIncome();
			}
		return totalAfterTaxes;
	}
	
	public double getFamilyBeforeTaxesIncome() {
		double beforeTaxes = 0.0;
		for (int i = 0; i < this.getPeopleList().size(); i++) {
			beforeTaxes += this.getPeopleList().get(i).getBeforeTaxIncome();
			}
		return beforeTaxes;
	}
	
	public double getFamilyTaxesDue() {
		return this.getFamilyBeforeTaxesIncome() - this.getFamilyAfterTaxesIncome();
	}
	
	public double getFamilyYearlyExpenses() {
		double yearlyExpenses = 0.0;
		for (int i = 0; i < this.getPeopleList().size(); i++) {
			yearlyExpenses += this.getPeopleList().get(i).getYearlyExpenses();
			}
		return yearlyExpenses;
	}
	
	public double getFamilySavings() {
		return this.getFamilyAfterTaxesIncome() - this.getFamilyYearlyExpenses();
	}

	
	/**
	 * Adds a new person onto the family, at the end of the ArrayList.
	 * @param currentPerson Person object to be added.
	 */
	
	public void addPersonToFamily(Person currentPerson) {
		this.getPeopleList().add(currentPerson);
	}
	
	/**
	 * peopleList getter method.
	 * @return peopleList
	 */

	public ArrayList<Person> getPeopleList() {
		return peopleList;
	}

	/**
	 * peopleList setter method. Private.
	 * @param peopleList to be set.
	 */
	private void setPeopleList(ArrayList<Person> peopleList) {
		this.peopleList = peopleList;
	}

}
