package application;

public class AlbertaTax extends Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public AlbertaTax() {
		
	}
	/**
	 * Uses the same calculations from the equivalent method from AlbertaTax's parent, Tax,
	 * but with different tax brackets. Furthermore, this will return the provincial taxes due
	 * as well as the federal taxes due by calling on the parent method using the super keyword.
	 * 
	 * @see calculateTaxDue() in Tax
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
		return totalTaxes + super.calculateTaxDue();
	}
	

}
