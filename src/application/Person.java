package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Person {
	
	private double beforeTaxIncome;
	private String name;
	private Tax taxes;
	
	private HBox fieldContainer;
	private TextField nameTextfield;

	public Person() {
		
	}
	
	public HBox createHBoxField() {
		HBox currentHBox = new HBox();
		Label nameLabel = new Label();
		Label incomeLabel = new Label();
		TextField incomeTextfield = new TextField(); 
		TextField nameTextfield = new TextField();
		nameLabel.setText("  Name:  ");
		incomeTextfield.setText("   Annual Income:   ");
		currentHBox.getChildren().addAll(nameLabel,nameTextfield,incomeLabel, incomeTextfield);
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

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
