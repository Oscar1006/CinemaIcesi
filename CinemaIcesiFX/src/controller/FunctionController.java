package controller;

import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.GregorianCalendar;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;

import model.Room;

public class FunctionController extends Controller{


	@FXML
	private TextField txtFilmName;

	@FXML
	private ComboBox<Room> comboBoxRooms;

	@FXML
	private DatePicker dPFunctionDay;

	private LocalDate nowDate;
	
	@FXML
	private ToggleButton togAM;
	@FXML
	private ToggleButton togPM;

	private ToggleGroup toggleAM_PM;

	@FXML
	private Spinner<Integer> spHours;

	@FXML
	private Spinner<Integer> spMinutes;

	@FXML
	private TextField txtMinutesDuration;

	@FXML
	private Button btnCreateFunction;
	
	private Alert alert;
	
	private Stage currentStage;
	@FXML
	public void initialize() {
		alert = new Alert(AlertType.ERROR);
		
		
		// Set datePicker
		nowDate = LocalDate.now();
		dPFunctionDay.setValue(nowDate);
		dPFunctionDay.setEditable(false);
		dPFunctionDay.setConverter(new LocalDateStringConverter(FormatStyle.FULL));
		
		Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				this.setDisable(false);

				// Disable past days
				if (item.isBefore(nowDate)) {
					this.setDisable(true);
				}
			}
		};
		dPFunctionDay.setDayCellFactory(dayCellFactory);

		// Set hour spinners
		SpinnerValueFactory<Integer> valueHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12);
		valueHours.setValue(6);
		spHours.setValueFactory(valueHours);
		SpinnerValueFactory<Integer> valueMinutes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60);
		valueMinutes.setValue(30);
		spMinutes.setValueFactory(valueMinutes);

		// Toggle AM and PM buttons
		toggleAM_PM = new ToggleGroup();
		togAM.setToggleGroup(toggleAM_PM);
		togPM.setToggleGroup(toggleAM_PM);
		togAM.setSelected(true);
	}
	
	@FXML
	@Override
	public void intializeData() {
		// Rooms options comboBox
		ObservableList<Room> observableRooms;
		observableRooms = FXCollections.observableList(super.getMain().getIcesinema().getRooms());
		comboBoxRooms.setItems(observableRooms);
		comboBoxRooms.setConverter(new StringConverter<Room>() {
			@Override
			public String toString(Room r) {
				return r.getName();
			}
			@Override
			public Room fromString(String string) {
				return null;
			}
		});
	}
	
	@FXML
	public void only3Numbers(KeyEvent event) {
		char c = event.getCharacter().charAt(0);
		if(!Character.isDigit(c) || txtMinutesDuration.getText().length() >= 3) {
			event.consume();
		}
	}

	@FXML
	public void createFunction(ActionEvent e) {
		if (txtFilmName.getText().isEmpty() || txtMinutesDuration.getText().isEmpty() || comboBoxRooms.getValue()==null) {
			alert.setTitle("Error");
			alert.setHeaderText("Por favor llene todos las campos");
			alert.showAndWait();
		}else {
			//Create film
			String filmName = txtFilmName.getText();
			int filmDuration = Integer.parseInt(txtMinutesDuration.getText());
			
			
			//Create Calendar
			int year = dPFunctionDay.getValue().getYear();
			int month = dPFunctionDay.getValue().getMonthValue();
			int day = dPFunctionDay.getValue().getDayOfMonth();
			int hour = spHours.getValue();
			if(toggleAM_PM.getSelectedToggle().equals(togPM)) {
				hour += 12;
			}
			int minute = spMinutes.getValue();
			GregorianCalendar date = new GregorianCalendar(year, month, day, hour, minute);
			
			//Select room
			int roomIndex = comboBoxRooms.getSelectionModel().getSelectedIndex();
			
	
			//Create function
			super.getMain().getIcesinema().createCinemaFunction(filmName, filmDuration, date, roomIndex);
			
			//Close window
			currentStage = (Stage) this.btnCreateFunction.getScene().getWindow();
			currentStage.close();
			//Save data
			Main.serialize();
		}
	}
}
