package application;

import exception.LogInException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Cinema;

public class LogInController {

	@FXML
	private TextField txtId;
	
	@FXML
	private Button btnLogIn;
	
	Cinema icesinema;
	
	@FXML
	private void initialize() {
		icesinema = new Cinema();
	}
	
	@FXML
	public void logIn(ActionEvent e) {
		
		
		String idToCheck = txtId.getText();
		
		try {
			if (icesinema.logInUWPerson(idToCheck)) {
				
				
				System.out.println("wtf");	
			}
		} catch (LogInException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
}
