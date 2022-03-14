package controller;


import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
    private ToggleButton seats[];
   
    
	@FXML
	@Override
	public void intializeData() {
		// Rooms options comboBox
		ObservableList<CinemaShow> observableShows;
		observableShows = FXCollections.observableList(super.getMain().getIcesinema().getShows());
		cbxCinemaShows.setItems(observableShows);
	}
	
	public void showSeats() {
		
		int indexShow = cbxCinemaShows.getSelectionModel().getSelectedIndex();
		boolean[][] reserved = super.getMain().getIcesinema().getReservedSeatsOfCinemaShow(indexShow);
		
		for (int f = 0; f < gpSeats.getParent().g; f++) {
			for (int c = 0; c < reserved[0].length ; c++) {
				gpSeats.add(seats[i], c, f);	
			}			
		}
		
		
		
		//Creating a graphic (image)
	    Image imgAvailableSeat = new Image(Main.AVAILABLE_SEAT_IMG);
	    Image imgReservedSeat = new Image(Main.RESERVED_SEAT_IMG);
	      
		
		seats = new ToggleButton[reserved.length * reserved[0].length];
		for (int i = 0; i < seats.length; i++) {
			ImageView viewAvailableSeat = new ImageView(imgAvailableSeat);
		    viewAvailableSeat.setFitHeight(50);
		    viewAvailableSeat.setPreserveRatio(true);
			seats[i] = new ToggleButton();
			seats[i].setGraphic(viewAvailableSeat);
		}
		
		int i = 0;
		for (int f = 0; f < reserved.length && i<seats.length; f++) {
			for (int c = 0; c < reserved[0].length ; c++) {
				gpSeats.add(seats[i], c, f);
				if(reserved[f][c]) {
					seats[i].setDisable(true);
					ImageView viewReservedSeat = new ImageView(imgReservedSeat);
				    viewReservedSeat.setFitHeight(50);
				    viewReservedSeat.setPreserveRatio(true);
					seats[i] = new ToggleButton();
					seats[i].setGraphic(viewReservedSeat);
				}
				i++;	
			}
		}
	}
	
    @FXML
    public void reserve() {

    }

}
