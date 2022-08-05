package application;

public class Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	public Tax () {
;
	}
	
	
	private double calculateAfterTaxIncome() {
		double btIncome = 0;
		btIncome += this.getBeforeTaxIncome();
		double totalTaxes = 0;
			if (btIncome > 216511) {
				totalTaxes += (btIncome - 216511) * 0.33;
				btIncome = 216511;
			}
			if (btIncome > 151978) {
				totalTaxes += (btIncome - 151978) * 0.29;
				btIncome = 151978;
			}
			if (btIncome > 98040) {
				totalTaxes += (btIncome - 98040) * 0.26;
				btIncome = 98040;
			}
			if (btIncome > 49020) {
				totalTaxes += (btIncome - 49020) * 0.205;
				btIncome = 49020;
			}
			if (btIncome >= 49020) {
				totalTaxes += btIncome * 0.29;
				btIncome = 151978;
			}
		return totalTaxes;
	}
	
	private double getBeforeTaxIncome() {
		return beforeTaxIncome;
	}
	private void setBeforeTaxIncome(double beforeTaxIncome) {
		this.beforeTaxIncome = beforeTaxIncome;
	}
	private double getAfterTaxIncome() {
		return afterTaxIncome;
	}
	private void setAfterTaxIncome(double afterTaxIncome) {
		this.afterTaxIncome = afterTaxIncome;
	}

}
