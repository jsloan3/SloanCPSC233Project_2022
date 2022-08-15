package application;

public class SasTax extends Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public SasTax() {
		
	}
	
	/**
	 * calculateTaxDue() but for Sask. tax brackets.
	 * See calculateTaxDue() within the AlbertaTax class.
	 * @return Provincial Sask. taxes + Federal taxes due as a double
	 */
	
	public double calculateTaxDue() {
		double btIncome = 0;
		btIncome += this.getBeforeTaxIncome();
		double totalTaxes = 0;
		double currentBracket = 130508;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.145;
			btIncome = currentBracket;
		}
		currentBracket = 45677;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.125;
			btIncome = currentBracket;
		}
		if (btIncome <= currentBracket) {
			totalTaxes += btIncome * 0.105;
			}
		return totalTaxes + calculateFedTax();
	}
	

}
