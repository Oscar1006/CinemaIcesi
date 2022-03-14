package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.CinemaShow;

public class ReserveController extends Controller {

	@FXML
	private ComboBox<CinemaShow> cbxCinemaShows;

	@FXML
	private GridPane gpSeats;

	@FXML
	private TextField txtSpectatorId;

	@FXML
	private TextField txtSpectatorName;

	@FXML
	private ToggleButton seats[][];
	
	@FXML
	private Button btnReserve;

	
	private int indexShow;
	private Alert alert;
	
	private Stage currentStage;


	@FXML
	private void initialize() {
		alert = new Alert(AlertType.ERROR);
	}

	@FXML
	@Override
	public void intializeData() {
		// Rooms options comboBox
		ObservableList<CinemaShow> observableShows;
		observableShows = FXCollections.observableList(super.getMain().getIcesinema().getShows());
		cbxCinemaShows.setItems(observableShows);
	}
	
	

	public void showSeats() {
		cbxCinemaShows.setDisable(true);
		indexShow = cbxCinemaShows.getSelectionModel().getSelectedIndex();
		boolean[][] reserved = super.getMain().getIcesinema().getReservedSeatsOfCinemaShow(indexShow);

		// Creating a graphic (image)
		Image imgAvailableSeat = new Image(Main.AVAILABLE_SEAT_IMG);
		Image imgReservedSeat = new Image(Main.RESERVED_SEAT_IMG);

		seats = new ToggleButton[reserved.length][reserved[0].length];

		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < reserved[0].length; j++) {
				ImageView viewAvailableSeat = new ImageView(imgAvailableSeat);
				viewAvailableSeat.setFitHeight(50);
				viewAvailableSeat.setPreserveRatio(true);
				seats[i][j] = new ToggleButton();
				seats[i][j].setGraphic(viewAvailableSeat);
				seats[i][j].setStyle("-fx-background-color: #F2F2F2");
				seats[i][j].setOnAction(actionEvent ->  {
				   
					ToggleButton tg =(ToggleButton)actionEvent.getSource();
					if(tg.isSelected()) {
						tg.setStyle("-fx-background-color: #F2CB9B");
					}else {
						tg.setStyle("-fx-background-color: #F2F2F2");
					}
				});

			}
		}
		
		for (int f = 0; f < reserved.length; f++) {
			for (int c = 0; c < reserved[0].length; c++) {
				
				gpSeats.add(seats[f][c], c, f);

				if (reserved[f][c]) {
					ImageView viewReservedSeat = new ImageView(imgReservedSeat);
					viewReservedSeat.setFitHeight(50);
					viewReservedSeat.setPreserveRatio(true);
					
					seats[f][c].setGraphic(viewReservedSeat);

					seats[f][c].setDisable(true);
				}
			}
		}
	}
	@FXML
	public void disableRoomOptrions() {
		
	}

	@FXML
	public void reserve() {
		
		if (txtSpectatorName.getText().isEmpty() || txtSpectatorId.getText().isEmpty() || cbxCinemaShows.getValue()==null) {
			alert.setTitle("Error");
			alert.setHeaderText("Por favor llene todos las campos");
			alert.showAndWait();
		}else {
			
			String name = txtSpectatorName.getText();
			String id = txtSpectatorId.getText();
			for (int i = 0; i < seats.length; i++) {
				for (int j = 0; j < seats[0].length; j++) {
					if(seats[i][j].isSelected()) {
						super.getMain().getIcesinema().reserveSeat(name, id, indexShow, i, j);;
					}
				}
			}
			
			//Close window
			currentStage = (Stage) this.btnReserve.getScene().getWindow();
			currentStage.close();
			//Save data
			Main.serialize();

		}
		
		
	}

}
