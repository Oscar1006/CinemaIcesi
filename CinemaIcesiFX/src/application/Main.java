package application;
	
import javafx.scene.image.Image;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static final String LOGIN_FXML = "../view/Login.fxml";
	public static final String PRINCIPAL_FXML = "../view/Principal.fxml";
	public static final String FUNCTION_FXML = "../view/Function.fxml";
	
	public static final String LOGO_IMG = "file:../../images/logo.png";
	
	
	private Parent root;
	private Stage currentStage;
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(getClass().getResource(LOGIN_FXML));
			scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(LOGO_IMG));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchScene(Stage s, String fxml) {
		try {
			root = FXMLLoader.load(getClass().getResource(fxml));
			scene = new Scene(root);
			currentStage = s;
			currentStage.setScene(scene);
		} catch (IOException er) {
			er.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
