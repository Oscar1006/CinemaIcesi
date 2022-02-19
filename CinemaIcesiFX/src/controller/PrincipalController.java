package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import model.Cinema;

public class PrincipalController{

    @FXML
    private Button btnCreateFunction;

    @FXML
    private Button btnGenerateReport;

    @FXML
    private Button btnReserveSeat;
    
	//private Cinema icesinema;
    
    private Main principalMain;
	
	@FXML
	private void initialize() {
		//icesinema = new Cinema();
		principalMain = new Main();
	}

    @FXML
    public void createFunction(ActionEvent event) {
    	principalMain.showWindow(Main.FUNCTION_FXML, Main.REEL_IMG);
    }

    @FXML
    public void generateReport(ActionEvent event) {

    }

    @FXML
    public void reserveSeat(ActionEvent event) {

    }

}
