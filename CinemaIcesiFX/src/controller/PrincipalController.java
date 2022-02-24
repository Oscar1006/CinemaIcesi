package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrincipalController extends Controller{

    

	@FXML
    private Button btnCreateFunction;

    @FXML
    private Button btnGenerateReport;

    @FXML
    private Button btnReserveSeat;
    
    
	@FXML
	private void initialize() {
		
	}

    @FXML
    public void createFunction() {
    	 FunctionController fC = (FunctionController) super.getMain().showWindow(Main.FUNCTION_FXML, Main.REEL_IMG);
    	 fC.roomOptions();
    }

    @FXML
    public void generateReport(ActionEvent event) {

    }

    @FXML
    public void reserveSeat(ActionEvent event) {

    }

}
