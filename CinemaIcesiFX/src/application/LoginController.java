package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private TextField txtId;
	
	@FXML
	private Button btnLogin;
	
	@FXML
	public void clickLogin(ActionEvent e) {
		
		String id = txtId.getText();
		
	}
	
	
	
	@FXML
	public void initialize() {
		
	}
	
	
}
