package controller;

import java.io.IOException;

import exception.LogInException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private void initialize() {
		icesinema = new Cinema();
	}
	
	@FXML
	public void logIn(ActionEvent e) throws IOException {
		
		String idToCheck = txtId.getText();
		
		try {
			if (icesinema.logInUWPerson(idToCheck)) {
				switchToPrincipal(e);
			}
		} catch (LogInException error) {
			System.out.println(error.getMessage());
		}
	}
	
	public void switchToPrincipal(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../view/Principal.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
