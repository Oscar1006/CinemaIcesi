package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//import model.Cinema;

public class PrincipalController{

    @FXML
    private Button btnCreateFunction;

    @FXML
    private Button btnGenerateReport;

    @FXML
    private Button btnReserveSeat;
    
    private FXMLLoader loader;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//private Cinema icesinema;
	
	@FXML
	private void initialize() {
		//icesinema = new Cinema();
	}

    @FXML
    public void createFunction(ActionEvent event) {
    	loader = new FXMLLoader(getClass().getResource("../view/Function.fxml"));
    	try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	scene = new Scene(root);
    	stage = new Stage();
    	stage.setScene(scene);
		stage.getIcons().add(new Image("file:../../images/reel.png"));
    	stage.show();
    }

    @FXML
    public void generateReport(ActionEvent event) {

    }

    @FXML
    public void reserveSeat(ActionEvent event) {

    }

}
