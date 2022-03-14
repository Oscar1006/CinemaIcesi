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
    public void createFunction() {
    	 super.getMain().showWindow(Main.FUNCTION_FXML, Main.REEL_IMG);
    }
    
    @FXML
    public void reserveSeat(ActionEvent event) {
    	super.getMain().showWindow(Main.RESERVE_FXML, Main.REEL_IMG);
    }
    @FXML
    public void generateReport(ActionEvent event) {
    	System.out.print(super.getMain().getIcesinema().generateReport());
    }



}
