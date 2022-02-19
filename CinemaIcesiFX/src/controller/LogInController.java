package controller;


import application.Main;
import exception.LogInException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cinema;

public class LogInController {

	@FXML
	private TextField txtId;
	
	@FXML
	private Button btnLogIn;
	
	private Cinema icesinema;
	
	private Main loginMain;
	
	private Stage currentStage;
	
	
	@FXML
	private void initialize() {
		icesinema = new Cinema();
		loginMain = new Main();
	}
	
	@FXML
	public void logIn(ActionEvent e) {
		
		String idToCheck = txtId.getText();
		
		try {
			icesinema.logInUWPerson(idToCheck);
			currentStage = (Stage)((Node)e.getSource()).getScene().getWindow();
			loginMain.switchScene(currentStage, Main.PRINCIPAL_FXML);
		} catch (LogInException error) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Usuario no autorizado");
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
	}
	
	
}
