package application;

public class BCTax extends Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public BCTax() {
		
	}
	
	/**
	 * calculateTaxDue() but for BC tax brackets.
	 * See calculateTaxDue() within the AlbertaTax class.
	 * @return Provincial BC taxes + Federal taxes due as a double
	 */
	
	public double calculateTaxDue() {
		double btIncome = 0;
		btIncome += this.getBeforeTaxIncome();
		double totalTaxes = 0;
		double currentBracket = 227091;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.205;
			btIncome = currentBracket;
		}
		currentBracket = 162832;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.1680;
			btIncome = currentBracket;
		}
		currentBracket = 120094;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.1470;
			btIncome = currentBracket;
		}
		currentBracket = 98901;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.1229;
			btIncome = currentBracket;
		}
		currentBracket = 86141;
			if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.105;
			btIncome = currentBracket;
			}
		currentBracket = 43070;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.0770;
			btIncome = currentBracket;
			}

		if (btIncome <= currentBracket) {
			totalTaxes += btIncome * 0.0506;
			}
		return totalTaxes + super.calculateTaxDue();
	}
	

}