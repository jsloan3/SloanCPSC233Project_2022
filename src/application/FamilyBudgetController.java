package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The FamilyBudgetController class is the controller class, meaning it is responsible for coordinating the other classes
 * and for setting up and gathering input from the GUI.
 * @author Jaxon Sloan
 *
 */

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
	
	/**
	 * ActionEvent method that is called when the 'Done' button is pressed.
	 * This method creates a new Person object according to the amount of family members requested by
	 * the user, and uses the PErson createHBoxField() method in order to construct the GUI and textfields
	 * for each family member.
	 * @param getFamilyMembersEvent
	 */
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
	
	/**
	 * ActionEvent method that is called once the 'Calculate' button is pressed.
	 * This method is meant to gather all the data inputed by the user for each family member.
	 * After that, it uses methods within the Family and Person classes in order to calculate
	 * total after taxes, total before taxes, total expenses, total savings andd total taxes due
	 * all for the entire family. Furthermore, it also sets the province state of each Person object
	 * within the family.
	 * @param calculateTaxesEvent
	 */
	@FXML
	// This controller method is called when the 'Calculate' button is pressed.
	void calculateTaxes(ActionEvent calculateTaxesEvent) {
		// Initialize our total to 0 to begin.
		double totalAfterTaxes = 0;
		double totalBeforeTaxes = 0;
		double totalExpenses = 0;
		double totalSavings = 0;
		double totalTaxesDue = 0;
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
		totalBeforeTaxes = mainFamily.getFamilyBeforeTaxesIncome();
		totalExpenses = mainFamily.getFamilyYearlyExpenses();
		totalTaxesDue = mainFamily.getFamilyTaxesDue();
		totalSavings = mainFamily.getFamilySavings();
		// Return the total family's after tax income as a formatted string to the user by setting a label.
		totalLabel.setText(String.format("Family Total Annual Income: $%.2f", totalAfterTaxes));
		taxDueLabel.setText(String.format("Total Annual Taxes Due: $%.2f", totalTaxesDue));
		totalExpensesLabel.setText(String.format("Total Annual Expenses: $%.2f", totalExpenses));
		savingsLabel.setText(String.format("Family Total Savings After Expenses: $%.2f", totalSavings));
		beforeTaxLabel.setText(String.format("Family Before-Tax Income: $%.2f", totalBeforeTaxes));
	}

}
