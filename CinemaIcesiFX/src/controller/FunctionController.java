package controller;

import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import model.Cinema;
import model.Film;
import model.Room;

public class FunctionController extends Controller{

	@FXML
	private TextField txtFilmName;

	@FXML
	private ComboBox<String> comboBoxRooms;

	private List<String> rooms;

	private ObservableList<String> observableRooms;

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

	private Cinema icesinema;
	
	private Film film;
	private String filmName;
	private int filmDuration;
	
	private Calendar date;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	private Room functionRoom;
	private String roomName;

	@FXML
	private void initialize() {
		icesinema = new Cinema();

		// Rooms options comboBox
		rooms = new ArrayList<String>();
		for (int i = 0; i < icesinema.getRooms().size(); i++) {
			rooms.add(icesinema.getRooms().get(i).getName());
		}
		observableRooms = FXCollections.observableList(rooms);
		comboBoxRooms.setItems(observableRooms);

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
		filmName = txtFilmName.getText();
		filmDuration = Integer.parseInt(txtMinutesDuration.getText());
		film = new Film(filmName, filmDuration);
		
		year = dPFunctionDay.getValue().getYear();
		month = dPFunctionDay.getValue().getMonthValue();
		day = dPFunctionDay.getValue().getDayOfMonth();
		hour = spHours.getValue();
		if(toggleAM_PM.getSelectedToggle().equals(togPM)) {
			hour += 12;
		}
		minute = spMinutes.getValue();
		
		date = new GregorianCalendar(year, month, day, hour, minute);
		
		roomName = comboBoxRooms.getSelectionModel().getSelectedItem();
		boolean found = false;
		for (int i = 0; i < icesinema.getRooms().size() && !found; i++) {
			if (icesinema.getRooms().get(i).getName().equals(roomName)) {
				functionRoom = icesinema.getRooms().get(i);
				found = true;
			}
		}
		
		icesinema.createCinemaFunction(film, date, functionRoom);
	}

}
