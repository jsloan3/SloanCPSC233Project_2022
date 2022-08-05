package application;

public class AlbertaTax extends Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public AlbertaTax() {
		
	}
	
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
		return totalTaxes + super.calculateTaxDue();
	}
	

}
