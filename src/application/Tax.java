package application;

public class Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	
	
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
