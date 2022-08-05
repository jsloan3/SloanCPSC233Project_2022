package application;

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
	
	private HBox createHBoxField() {
		HBox currentHBox = new HBox();
		TextField currentTextfield = new TextField();
		currentHBox.getChildren().add(currentTextfield);
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
