package application;

/**
 * The Tax class stores beforeTaxIncome and afterTaxIncome as doubles.
 * It is intended to contain and do calculations based on Canadian tax brackets.
 * This class is intended to be an Abstract class, with its main method calculateTaxDue()
 * intended to be overridden by its children class to do calculations based on a specific province.
 * @author Jaxon Sloan
 *
 */

public abstract class Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public Tax () {
;
	}
	
	/**
	 * Calculates taxes based on 2021-2022 Canadian Provincial Tax brackets.
	 * In the case of the parent Tax class, this will only ever return 0, as it is always intended to be overridden by its child classes.
	 * @return The amount of taxes due as a double. (Always 0 for the Tax abstract class)
	 */
	
	public double calculateTaxDue() {
		return 0;
	}
	
	/**
	 * Calculates taxes based on 2021-2022 Canadian Federal Tax brackets, and returns it as a double.
	 * Does this based on beforeTaxIncome.
	 * @return the amount of taxes due by a Person as a double.
	 */
	public double calculateFedTax() {
		// btIncome will be equal to our beforeTaxIncome var.
		double btIncome = 0;
		btIncome += this.getBeforeTaxIncome();
		double totalTaxes = 0;
		/*
		 * For each tax bracket, we find the amount above the tax bracket and multiply it
		 * by the tax percentage. We'll add that to the total taxes due, before dropping down
		 * to the next tax bracket and repeating through all the brackets.
		 */
		// Set the current bracket value.
		double currentBracket = 216511;
		// If we have more income than the current bracket, then we need to tax however much more we have.
		if (btIncome > currentBracket) {
			// So, add our income - currentBracket multiplied by the tax percentage.
			totalTaxes += (btIncome - currentBracket) * 0.33;
			// Then, drop our income down to the bracket for the next bracket to calculate.
			btIncome = currentBracket;
		}
		currentBracket = 151978;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.29;
			btIncome = currentBracket;
		}
		currentBracket = 98040;
			if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.26;
			btIncome = currentBracket;
			}
		currentBracket = 49020;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.205;
			btIncome = currentBracket;
			}

		if (btIncome <= currentBracket) {
			totalTaxes += btIncome * 0.15;
			}
		// Return the total amount due.
		return totalTaxes;
	}
	
	
	/**
	 * Calculates the taxes due using calculateTaxDue(), and subtracts it from
	 * a Person objects beforeTaxIncome, before setting the afterTaxIncome variable appropriately.
	 */
	public void calcAndSetTax() {
		double taxDue = this.calculateTaxDue();
		double beforeTax;
		beforeTax =+ this.getBeforeTaxIncome();
		this.setAfterTaxIncome(beforeTax - taxDue);
	}
	
	/**
	 * beforeTaxIncome getter
	 * @return beforeTaxIncome
	 */
	public double getBeforeTaxIncome() {
		return beforeTaxIncome;
	}
	/**
	 * beforeTaxIncome setter
	 * @param beforeTaxIncome
	 */
	public void setBeforeTaxIncome(double beforeTaxIncome) {
		this.beforeTaxIncome = beforeTaxIncome;
	}
	/**
	 * aeforeTaxIncome getter
	 * @return aeforeTaxIncome
	 */
	public double getAfterTaxIncome() {
		return afterTaxIncome;
	}
	/**
	 * afterTaxIncome setter
	 * @param afterTaxIncome
	 */
	public void setAfterTaxIncome(double afterTaxIncome) {
		this.afterTaxIncome = afterTaxIncome;
	}

}
