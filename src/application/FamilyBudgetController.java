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
	
	@FXML
	private TextField familyAmountTextbox;
	
	@FXML
	private VBox scrollVBox;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	void getFamilyMembers(ActionEvent getFamilyMembersEvent) {
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
			} 
		} else {
			errorLabel.setText("ERROR: Invalid Family Member # input: " + familyMemberAmountStr + ". Should be an integer.");
		}
	}

}
