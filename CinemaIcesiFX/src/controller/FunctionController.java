package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import model.Cinema;

public class FunctionController {

	@FXML
    private TextField txtFilmName;

    @FXML
    private ComboBox<String> comboBoxRooms;

    private List<String> rooms;
    
    private ObservableList<String> observableRooms;
    
    @FXML
    private DatePicker dPDate;


    @FXML
    private ToggleButton btnMeridiem;


    @FXML
    private Spinner<Integer> spHours;

    @FXML
    private Spinner<Integer> spMinutes;

    @FXML
    private Button btnCreateFunction;

    
    private Cinema icesinema;
    
    
    @FXML
	private void initialize() {
    	icesinema = new Cinema();
    	
    	//Rooms options
    	rooms = new ArrayList<String>();
    	for (int i = 0; i < icesinema.getRooms().size(); i++) {
			rooms.add(icesinema.getRooms().get(i).getName());
		}
    	observableRooms = FXCollections.observableList(rooms);
    	comboBoxRooms.setItems(observableRooms);
    	
    	//Set sppiners
		SpinnerValueFactory<Integer> valueHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 12);
		valueHours.setValue(0);
		spHours.setValueFactory(valueHours);
		SpinnerValueFactory<Integer> valueMinutes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60);
		valueMinutes.setValue(30);
		spMinutes.setValueFactory(valueMinutes);
		
	}
    
    @FXML
	public void createFunction(ActionEvent e) throws IOException {
		String filmName = txtFilmName.getText();
		String room = comboBoxRooms.getSelectionModel().getSelectedItem();
		System.out.println(filmName+"  "+room);
    }

}
