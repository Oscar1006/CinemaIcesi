package application;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Cinema;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	public static final String LOGIN_FXML = "../view/Login.fxml";
	public static final String PRINCIPAL_FXML = "../view/Principal.fxml";
	public static final String FUNCTION_FXML = "../view/Function.fxml";
	public static final String RESERVE_FXML = "../view/Reserve.fxml";

	public static final String LOGO_IMG = "file:../../images/logo.png";
	public static final String REEL_IMG = "file:../../images/reel.png";

	public static final String AVAILABLE_SEAT_IMG = "file:../../images/seat-available.png";
	public static final String RESERVED_SEAT_IMG = "file:../../images/seat-reserved.png";

	private Parent root;
	private Stage currentStage;
	private Stage newStage;
	private Scene scene;
	private FXMLLoader loader;

	private Cinema icesinema = new Cinema();

	@Override
	public void start(Stage primaryStage) {
		try {
			
			showWindow(LOGIN_FXML, LOGO_IMG);
			deserialize();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void serialize() {

		File file = new File("files/dataCinema.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(icesinema);
			
			oos.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Serializado");
	}
	
	public void deserialize() {
		File file = new File("files/dataCinema.txt");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			icesinema = (Cinema) ois.readObject();
			System.out.println(icesinema);
			
			ois.close();
			fis.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void showWindow(String windowScene, String windowIcon) {
		Controller controller = new Controller();
		try {
			loader = new FXMLLoader(getClass().getResource(windowScene));

			root = loader.load();
			controller = loader.getController();
			controller.setMain(this);
			controller.intializeData();

			scene = new Scene(root);

			newStage = new Stage();
			newStage.getIcons().add(new Image(windowIcon));
			newStage.setScene(scene);
			newStage.show();
			currentStage = newStage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void switchScene(Controller controller, String nextScene) {
		try {
			loader = new FXMLLoader(getClass().getResource(nextScene));

			root = loader.load();

			controller = loader.getController();
			controller.setMain(this);

			scene = new Scene(root);
			currentStage.setScene(scene);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public Cinema getIcesinema() {
		return icesinema;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
