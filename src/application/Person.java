package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Person {
	
	private double beforeTaxIncome;
	private String name;
	private Tax taxes;
	
	private TextField nameTextfield;
	private TextField incomeTextfield;

	public Person() {

	}
	
	public HBox createHBoxField() {
		HBox currentHBox = new HBox();
		Label nameLabel = new Label();
		Label incomeLabel = new Label();
		this.setIncomeTextfield(new TextField());
		this.setNameTextfield(new TextField());
		nameLabel.setText("   Name:   ");
		incomeLabel.setText("   Annual Income:   ");
		currentHBox.getChildren().addAll(nameLabel,this.getNameTextfield(),incomeLabel, this.getIncomeTextfield());
		return currentHBox;
	}
	
	public String processInput() {
		String nameStr;
		String incomeStr;
		if (this.getNameTextfield() != null && this.getIncomeTextfield() != null
				&& this.getNameTextfield().getText() != "" && this.getIncomeTextfield().getText() != "") {
		nameStr = this.getNameTextfield().getText();
		incomeStr = this.getIncomeTextfield().getText();
		} else {
			return "ERROR: One or more fields are empty.";
		}
		for (int i = 0 ; i < nameStr.length() ; i++) {
			if (!Character.isAlphabetic(nameStr.charAt(i))) {
				return "ERROR: " + nameStr + " is not a valid name. Must be letters only.";
			}
		}
		int decimalCount = 0;
		for (int r = 0 ; r < incomeStr.length(); r++) {
			if (incomeStr.endsWith(".")) {
				return "ERROR: Income shouldn't end with a decimal.";
			}
			if (decimalCount > 1) {
				return "ERROR: Too many decimals.";
			}
			if (!Character.isDigit(incomeStr.charAt(r))) {
				if (incomeStr.charAt(r) == '.') {
					decimalCount++;
				} else {
					return "ERROR: " + incomeStr + " is not a valid income amount. "
							+ "Must be digits only, and at most one decimal.";
				}
			}
		}
		
		this.setName(nameStr);
		this.setBeforeTaxIncome(Double.parseDouble(incomeStr));
		this.getTaxes().setBeforeTaxIncome(Double.parseDouble(incomeStr));
		
		
		
		
		return "";
		
	}

	
	public int setTaxProvince(String residence) {
		if (residence == "Alberta") {
			this.setTaxes(new AlbertaTax());
			return 1;
		}
		if (residence.equals("British Columbia")) {
			this.taxes = new BCTax();
		}
		if (residence.equals("Saskatchewan")) {
			this.taxes = new SasTax();
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TextField getIncomeTextfield() {
		return incomeTextfield;
	}

	private void setIncomeTextfield(TextField incomeTextfield) {
		this.incomeTextfield = incomeTextfield;
	}

	public TextField getNameTextfield() {
		return nameTextfield;
	}

	private void setNameTextfield(TextField nameTextfield) {
		this.nameTextfield = nameTextfield;
	}

	private double getBeforeTaxIncome() {
		return beforeTaxIncome;
	}

	private void setBeforeTaxIncome(double beforeTaxIncome) {
		this.beforeTaxIncome = beforeTaxIncome;
	}

	public Tax getTaxes() {
		return taxes;
	}
	
	public void setTaxes(Tax taxes) {
		this.taxes = taxes;
	}
}
