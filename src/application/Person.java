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
		incomeLabel.setText("   Annual Income:  ");
		currentHBox.getChildren().addAll(nameLabel,this.getNameTextfield(),incomeLabel, this.getIncomeTextfield());
		return currentHBox;
	}
	
	private int setTaxProvince(String residence) {
		if (residence.equals("Alberta")) {
			this.taxes = new AlbertaTax();
			return 1;
		} else {
			return 0;
		}
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
}
