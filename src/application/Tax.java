package application;

public class Tax {
	
	private double beforeTaxIncome;
	private double afterTaxIncome;
	private String province;
	
	public Tax (String residence) {
		this.setProvince(residence);
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
	private void setProvince(String residence) {
		this.province = residence;
	}

}
