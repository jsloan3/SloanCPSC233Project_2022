package application;


/**
 * A child class of the Tax class. Overrides the calculateTaxDue() method in order to calculate taxes based
 * on its own provincial tax brackets. In this case, Alberta.
 * @author Jaxon Sloan
 *
 */

public class AlbertaTax extends Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public AlbertaTax() {
		
	}
	/**
	 * Uses the same calculations from the equivalent method from AlbertaTax's parent, Tax,
	 * but with different tax brackets. Furthermore, this will return the provincial taxes due.
	 * Uses the calculateFedTax() parent method to calculate federal tax brackets as well.
	 * 
	 * @see calculateFedTax() in Tax
	 * @return Provincial Alberta taxes + Federal taxes due as a double
	 */
	public double calculateTaxDue() {
		double btIncome = 0;
		btIncome += this.getBeforeTaxIncome();
		double totalTaxes = 0;
		double currentBracket = 314928;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.15;
			btIncome = currentBracket;
		}
		currentBracket = 209952;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.14;
			btIncome = currentBracket;
		}
		currentBracket = 157464;
			if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.13;
			btIncome = currentBracket;
			}
		currentBracket = 131220;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.12;
			btIncome = currentBracket;
			}

		if (btIncome <= currentBracket) {
			totalTaxes += btIncome * 0.10;
			}
		// Return our provincial taxes due, but also call upon the Parent method to get our federal taxes due.
		return totalTaxes + calculateFedTax();
	}
	

}
