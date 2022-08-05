package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Person {
	
	private double beforeTaxIncome;
	private String name;
	private Tax taxes;
	
	private TextField nameTextfield;
	private TextField incomeTextfield;

	public Person() {

	}
	
	
	/**
	 * Creates an HBox and puts two labels and two textfields inside of it for formatting, one for a name and one for an income.
	 * Furthermore, it will use setter methods to set the object's instance variables nameTextfield and incomeTextfield to the newly
	 * created textfields within the HBox.
	 * 
	 * @return the created HBox
	 */
	public HBox createHBoxField() {
		// Create an HBox.
		HBox currentHBox = new HBox();
		Label nameLabel = new Label();
		Label incomeLabel = new Label();
		// New textfields are made for both the object's income and name textfield vars.
		this.setIncomeTextfield(new TextField());
		this.setNameTextfield(new TextField());
		// We set the labels for each to something appropriate.
		nameLabel.setText("   Name:   ");
		incomeLabel.setText("   Annual Income:   ");
		// Set them to the HBox's children in correct order.
		currentHBox.getChildren().addAll(nameLabel,this.getNameTextfield(),incomeLabel, this.getIncomeTextfield());
		// Return the HBox, now with all the textfields and labels as its children.
		return currentHBox;
	}
	
	/**
	 * Checks the Person object's income and name textfield instance variables using getter methods for bad input. Bad input is 
	 * considered anything with more than one decimal or non-digits in the case of the income, or anything that is not alphabetical
	 * in the case of the name. If bad input is found, a respective error message is returned. Otherwise, an empty string is returned and the
	 * textfields are parsed to a string and double respectively to be stored within the name and beforeTaxIncome instance variables respectively.
	 * @return An error message in the case of bad input, or an empty string if input is good.
	 */
	
	public String processInput() {
		String nameStr;
		String incomeStr;
		
		/*
		 * Bad input checker. If input is an empty string or simply null, don't let it .getText()
		 * or we'll face an error. In the case there is a bad input, return an error message that
		 * tells the user what went wrong.
		 */
		if (this.getNameTextfield() != null && this.getIncomeTextfield() != null
				&& this.getNameTextfield().getText() != "" && this.getIncomeTextfield().getText() != "") {
		nameStr = this.getNameTextfield().getText();
		incomeStr = this.getIncomeTextfield().getText();
		} else {
			return "ERROR: One or more fields are empty.";
		}
		/* Checks through the whole name string to see if the characters are alphabetic.
		 * If not, we give the user an appropriate error.
		 */
		for (int i = 0 ; i < nameStr.length() ; i++) {
			if (!Character.isAlphabetic(nameStr.charAt(i))) {
				return "ERROR: " + nameStr + " is not a valid name. Must be letters only.";
			}
		}
		// Initialize the amount of decimals at 0.
		int decimalCount = 0;
		for (int r = 0 ; r < incomeStr.length(); r++) {
			// Numbers should never end with a decimal, so error if it does.
			if (incomeStr.endsWith(".")) {
				return "ERROR: Income shouldn't end with a decimal.";
			}
			// If we've got more than 1 decimal its not a good input.
			if (decimalCount > 1) {
				return "ERROR: Too many decimals.";
			}
			// If the current character isn't a digit, the user didn't pass through a number.
			if (!Character.isDigit(incomeStr.charAt(r))) {
				// If the current character is a decimal, add to the decimal count.
				if (incomeStr.charAt(r) == '.') {
					decimalCount++;
				// In the case that there's a non-digit character, error and tell the user.
				} else {
					return "ERROR: " + incomeStr + " is not a valid income amount. "
							+ "Must be digits only, and at most one decimal.";
				}
			}
		}
		
		/* We should only be here if there's no errors and everything's been error-checked, so we can freely set 
		 * our instance variables without worrying. 
		 */
		this.setName(nameStr);
		this.setBeforeTaxIncome(Double.parseDouble(incomeStr));
		// Set our tax instance object's beforeTaxIncome to our error-checked income, too.
		this.getTaxes().setBeforeTaxIncome(Double.parseDouble(incomeStr));
		
		return "";
		
	}

	/**
	 * Sets the Person object's 'taxes' instance variable to a new Tax child-class object based on the string received.
	 * If no matching string is received, does nothing.
	 * 
	 * @param residence The name of the province intended to create a Tax child-class object of.
	 */
	public void setTaxProvince(String residence) {
		/*
		 * Every province has its own tax bracket system, so we'll use a subclass of the Tax
		 * class with its own overriding method to calculate its own taxes.
		 */
		if (residence.equals("Alberta")) {
			this.setTaxes(new AlbertaTax());
		}
		if (residence.equals("British Columbia")) {
			this.setTaxes(new BCTax());
		}
		if (residence.equals("Saskatchewan")) {
			this.setTaxes(new SasTax());
		}
	}
	
	/**
	 * Name instance variable getter method
	 * @return name
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * Name instance variable setter method
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * incomeTextfield instance variable getter method
	 * @return incomeTextfield
	 */

	public TextField getIncomeTextfield() {
		return incomeTextfield;
	}
	
	/**
	 * incomeTextfield instance variable setter method
	 * @param incomeTextfield
	 */

	private void setIncomeTextfield(TextField incomeTextfield) {
		this.incomeTextfield = incomeTextfield;
	}
	
	/**
	 * nameTextfield getter method
	 * @return nameTextfield
	 */

	public TextField getNameTextfield() {
		return nameTextfield;
	}
	
	/**
	 * nameTextfield setter method
	 * @param nameTextfield
	 */

	private void setNameTextfield(TextField nameTextfield) {
		this.nameTextfield = nameTextfield;
	}
	
	/**
	 * beforeTaxIncome setter method
	 * @param beforeTaxIncome
	 */

	private void setBeforeTaxIncome(double beforeTaxIncome) {
		this.beforeTaxIncome = beforeTaxIncome;
	}
	
	/**
	 * taxes getter method
	 * @return taxes
	 */

	public Tax getTaxes() {
		return taxes;
	}
	
	/**
	 * taxes setter method
	 * @param taxes
	 */
	
	public void setTaxes(Tax taxes) {
		this.taxes = taxes;
	}
}
