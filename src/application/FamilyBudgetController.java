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
	// We only use one family for this calculator, so we'll set it here early.
	Family mainFamily = new Family();
	
	@FXML
	private Label totalLabel;
	
	@FXML
	private Label taxDueLabel;
	
	@FXML
	private Label totalExpensesLabel;
	
	@FXML
	private Label savingsLabel;
	
	@FXML
	private Label beforeTaxLabel;
	
	@FXML
	private TextField familyAmountTextbox;
	
	@FXML
	private VBox scrollVBox;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private ChoiceBox<String> provinceChoiceBox;
	
	// This controller method is called when the 'Done' button is pressed.
	@FXML
	void getFamilyMembers(ActionEvent getFamilyMembersEvent) {
				mainFamily.clearPeopleList();
				String familyMemberAmountStr = familyAmountTextbox.getText();
				String errorMessage = mainFamily.checkFamilyAmount(familyMemberAmountStr);

				if (errorMessage == "") {
					scrollVBox.getChildren().clear();
					int familyMemberAmount = Integer.parseInt(familyMemberAmountStr);
					for (int i = 0; i < familyMemberAmount; i++) {
						Person currentPerson = new Person();
						scrollVBox.getChildren().add(currentPerson.createHBoxField());
						mainFamily.addPersonToFamily(currentPerson);
					} 
				} else {
					errorLabel.setText(errorMessage);
				}
	}
	
	@FXML
	// This controller method is called when the 'Calculate' button is pressed.
	void calculateTaxes(ActionEvent calculateTaxesEvent) {
		// Initialize our total to 0 to begin.
		double totalAfterTaxes = 0;
		// Make sure there's no error left over.
		errorLabel.setText("");
		for (int i = 0 ; i < mainFamily.getPeopleList().size() ; i++) {
			String errorMessage = "";
			// Set every People object's province variable to what the user put in the choicebox.
			mainFamily.getPeopleList().get(i).setTaxProvince(provinceChoiceBox.getValue());
			/* processInput will validate the user's input and throw an error message if its bad, which we'll store.
			 * Not only that, but it will set the object's instance variables in preparation for further method calls.
			 */
			errorMessage = errorMessage + mainFamily.getPeopleList().get(i).processInput();
			// If the error message is anything but an empty string, something went wrong. Return to end the method call.
			if (!(errorMessage == "")) {
				errorLabel.setText(errorMessage);
				return;
			}
			mainFamily.getPeopleList().get(i).getTaxes().calcAndSetTax();
			System.out.print(mainFamily.getPeopleList().get(i).getTaxes().getAfterTaxIncome());
		}
		
		totalAfterTaxes = mainFamily.getFamilyAfterTaxesIncome();
		// Return the total family's after tax income as a formatted string to the user by setting a label.
		totalLabel.setText(String.format("Family Total Annual Income: $%.2f", totalAfterTaxes));
	}

}
