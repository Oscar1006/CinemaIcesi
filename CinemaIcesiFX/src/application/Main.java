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
	public static final String REEL_IMG = "file:../../images/reel.png";
	
	
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(getClass().getResource(LOGIN_FXML));
			scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(LOGO_IMG));
			primaryStage.show();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void switchScene(Stage currentStage, String nextScene) {
		try {
			root = FXMLLoader.load(getClass().getResource(nextScene));
			scene = new Scene(root);
			currentStage.setScene(scene);
		} catch (IOException ex) {
			ex.printStackTrace();
		}	
	}
	
	public void showWindow(String windowScene, String windowIcon) {
		try {
			root = FXMLLoader.load(getClass().getResource(windowScene));
			stage = new Stage(); 
			scene = new Scene(root);
			stage.getIcons().add(new Image(windowIcon));
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
