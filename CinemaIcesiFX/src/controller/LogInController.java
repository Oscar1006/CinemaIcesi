package controller;

import application.Main;
import exception.LogInException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LogInController extends Controller {

	@FXML
	private TextField txtId;
	
	@FXML
	private Button btnLogIn;
	
	
	private Alert alert;
	@FXML
	private void initialize() {
		alert = new Alert(AlertType.ERROR);
	}

	@FXML
	public void logIn(ActionEvent ev) {
		
		String idToCheck = txtId.getText();
		
		try {
			super.getMain().getIcesinema().logInUWPerson(idToCheck);
			super.getMain().switchScene(new PrincipalController(), Main.PRINCIPAL_FXML);
		} catch (LogInException ex) {
			alert.setTitle("Error");
			alert.setHeaderText("Usuario no autorizado");
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
		}
	}
	
	@FXML
	public void noSpace(KeyEvent event) {
		char c = event.getCharacter().charAt(0);
		if(Character.isWhitespace(c)) {
			event.consume();
		}
	}
	
}
