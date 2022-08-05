package application;

public class Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public Tax () {
;
	}
	
	/**
	 * Calculates taxes based on 2021-2022 Canadian Federal Tax brackets.
	 * Returns the taxes due based on the beforeTaxIncome variable.
	 * @return The amount of taxes due as a double.
	 */
	public double calculateTaxDue() {
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
