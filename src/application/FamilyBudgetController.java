package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FamilyBudgetController {
	Stage mainStage;
	Family mainFamily = new Family();
	
	@FXML
	private TextField familyAmountTextbox;
	
	@FXML
	private VBox scrollVBox;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private ChoiceBox<String> provinceChoiceBox;
	
	@FXML
	void getFamilyMembers(ActionEvent getFamilyMembersEvent) {
		mainFamily.clearPeopleList();
		String familyMemberAmountStr = familyAmountTextbox.getText();
		boolean isError = false;
		for (int i = 0; i < familyMemberAmountStr.length(); i++) {
			if (!Character.isDigit(familyMemberAmountStr.charAt(i))) {
				isError = true;
				break;
			}
		}
		System.out.print(isError);
		if (!isError) {
			scrollVBox.getChildren().clear();
			int familyMemberAmount = Integer.parseInt(familyMemberAmountStr);
			for (int i = 0; i < familyMemberAmount; i++) {
				Person currentPerson = new Person();
				scrollVBox.getChildren().add(currentPerson.createHBoxField());
				mainFamily.addPersonToFamily(currentPerson);
			} 
		} else {
			errorLabel.setText("ERROR: Invalid Family Member # input: " + familyMemberAmountStr + ". Should be an integer.");
		}
	}
	
	@FXML
	void calculateTaxes(ActionEvent calculateTaxesEvent) {
		double totalAfterTaxes = 0;
		errorLabel.setText("");
		for (int i = 0 ; i < mainFamily.getPeopleList().size() ; i++) {
			String errorMessage = "";
			mainFamily.getPeopleList().get(i).setTaxProvince(provinceChoiceBox.getValue());
			errorMessage = errorMessage + mainFamily.getPeopleList().get(i).processInput();
			if (!(errorMessage == "")) {
				errorLabel.setText(errorMessage);
				return;
			}
			
			double taxDue = mainFamily.getPeopleList().get(i).getTaxes().calculateTaxDue();
			mainFamily.getPeopleList().get(i).getTaxes().setAfterTaxIncome(mainFamily.getPeopleList().get(i).getTaxes().getBeforeTaxIncome() - taxDue);
			System.out.print(" " + mainFamily.getPeopleList().get(i).getTaxes().getAfterTaxIncome());
			totalAfterTaxes += mainFamily.getPeopleList().get(i).getTaxes().getAfterTaxIncome();
			
			
		}
		
	}

}
