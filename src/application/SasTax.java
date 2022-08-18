package application;

/**
 * A child class of the Tax class. Overrides the calculateTaxDue() method in order to calculate taxes based
 * on its own provincial tax brackets. In this case, Saskatchewan.
 * @author Jaxon Sloan
 *
 */

public class SasTax extends Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public SasTax() {
		
	}
	
	/**
	 * calculateTaxDue() but for Sask. tax brackets.
	 * See calculateTaxDue() within the AlbertaTax class.
	 * Uses the calculateFedTax() parent method to calculate federal tax brackets.
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
