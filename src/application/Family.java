package application;

import java.util.ArrayList;

/**
 * The Family class is an object that has an ArrayList of people objects as its single instance variable. As such, 
 * it is intended to control the calculations on an entire family of Person objects.
 * @author Jaxon Sloan
 *
 */

public class Family {
	
	private ArrayList<Person> peopleList;
	
	// The constructor calls the clearPeopleList() method to create a new ArrayList of type Person
	public Family() {
		this.clearPeopleList();
	}
	
	/**
	 * This method verifies that the user input for the amount of family members is a digit.
	 * Takes a string as input.
	 * @param familyMemberAmountStr
	 * @return An empty string if the string is an integer, or an appropriate error as a string otherwise.
	 */
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
	
	/**
	 * Returns the income of every Person object within the peopleList instance variable after taxes.
	 * @return Total income of a family after taxes as a sum, as a double.
	 */
	
	public double getFamilyAfterTaxesIncome() {
		double totalAfterTaxes = 0.0;
		for (int i = 0; i < this.getPeopleList().size(); i++) {
			totalAfterTaxes += this.getPeopleList().get(i).getTaxes().getAfterTaxIncome();
			}
		return totalAfterTaxes;
	}
	
	/**
	 * Returns the income of every Person object within the peopleList instance variable before taxes.
	 * @return Total income before taxes of a family, as a double.
	 */
	
	public double getFamilyBeforeTaxesIncome() {
		double beforeTaxes = 0.0;
		for (int i = 0; i < this.getPeopleList().size(); i++) {
			beforeTaxes += this.getPeopleList().get(i).getBeforeTaxIncome();
			}
		return beforeTaxes;
	}
	
	/**
	 * Returns the total amount of taxes due of a whole family.
	 * @return Total taxes due of a family, as a double.
	 */
	
	public double getFamilyTaxesDue() {
		return this.getFamilyBeforeTaxesIncome() - this.getFamilyAfterTaxesIncome();
	}
	
	/**
	 * Gets the expenses of a whole family as a sum.
	 * @return The expenses of an entire family, summed to a double.
	 */
	
	public double getFamilyYearlyExpenses() {
		double yearlyExpenses = 0.0;
		for (int i = 0; i < this.getPeopleList().size(); i++) {
			yearlyExpenses += this.getPeopleList().get(i).getYearlyExpenses();
			}
		return yearlyExpenses;
	}
	
	/**
	 * Savings is defined as after taxes income - yearly expenses.
	 * @return Total family yearly savings.
	 */
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
