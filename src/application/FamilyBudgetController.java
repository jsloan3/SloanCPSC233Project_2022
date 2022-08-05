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
		// First, clear the mainFamily object to stop any stowaway People objects from earlier.
		mainFamily.clearPeopleList();
		// Temporary variable for error checking purposes.
		String familyMemberAmountStr = familyAmountTextbox.getText();
		// Initialize the error boolean as false to start off.
		boolean isError = false;
		
		/*
		 * The family member amount should be an integer, so if the user put in anything but digits
		 * we should throw an error. A for loop that cycles through every character makes this easy
		 * to check.
		 */
		for (int i = 0; i < familyMemberAmountStr.length(); i++) {
			if (!Character.isDigit(familyMemberAmountStr.charAt(i))) {
				isError = true;
				break;
			}
		}
		
		// If there's no error, we can continue.
		if (!isError) {
			// Clear out the VBox within the scrollpane so that we don't add to what's there.
			scrollVBox.getChildren().clear();
			// We can parse the user input to an int now that we know its error-free.
			int familyMemberAmount = Integer.parseInt(familyMemberAmountStr);
			/*
			 * We want to create as many Person objects and add their HBoxes to the scrollpane
			 * as the user inputed. Furthermore, each new Person object should be added to the 
			 * Family ArrayList object.
			 */
			for (int i = 0; i < familyMemberAmount; i++) {
				Person currentPerson = new Person();
				scrollVBox.getChildren().add(currentPerson.createHBoxField());
				mainFamily.addPersonToFamily(currentPerson);
			} 
			// Otherwise, throw the user an error if they inputed something wrong.
		} else {
			errorLabel.setText("ERROR: Invalid Family Member # input: " + familyMemberAmountStr + ". Should be an integer.");
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
			
			// Get what a Person object owes in taxes using the calculateTaxDue() Tax method, based on their provincial subclass.
			double taxDue = mainFamily.getPeopleList().get(i).getTaxes().calculateTaxDue();
			// Set a person's afterTaxIncome to their beforeTaxIncome - what they owe using a setter method.
			mainFamily.getPeopleList().get(i).getTaxes().setAfterTaxIncome(mainFamily.getPeopleList().get(i).getTaxes().getBeforeTaxIncome() - taxDue);
			// Now that we have a People object's income after taxes, we can add it to a total for the whole family.
			totalAfterTaxes += mainFamily.getPeopleList().get(i).getTaxes().getAfterTaxIncome();
		}
		
		// Return the total family's after tax income as a formatted string to the user by setting a label.
		totalLabel.setText(String.format("Family Total Annual Income: $%.2f", totalAfterTaxes));
	}

}
