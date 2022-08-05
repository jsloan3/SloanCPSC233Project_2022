package application;

public class Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public Tax () {
;
	}
	
	
	public double calculateTaxDue() {
		double btIncome = 0;
		btIncome += this.getBeforeTaxIncome();
		double totalTaxes = 0;
		double currentBracket = 216511;
		if (btIncome > currentBracket) {
			totalTaxes += (btIncome - currentBracket) * 0.33;
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
		return totalTaxes;
	}
	
	public double getBeforeTaxIncome() {
		return beforeTaxIncome;
	}
	public void setBeforeTaxIncome(double beforeTaxIncome) {
		this.beforeTaxIncome = beforeTaxIncome;
	}
	public double getAfterTaxIncome() {
		return afterTaxIncome;
	}
	public void setAfterTaxIncome(double afterTaxIncome) {
		this.afterTaxIncome = afterTaxIncome;
	}

}
