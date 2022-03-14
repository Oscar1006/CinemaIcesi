//University Welfare
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import exception.LogInException;

public class Cinema {

	private ArrayList<Room> rooms;
	private ArrayList<Film> films;
	private ArrayList<CinemaShow> shows;
	private ArrayList<Person> spectators;
	private ArrayList<UniversityWalfarePerson> universityWPersons;
	

	public Cinema() {
		rooms = new ArrayList<>();
		films = new ArrayList<>();
		shows = new ArrayList<>();
		universityWPersons = new ArrayList<>();
		spectators = new ArrayList<>();
		readData();
	}

	public void buildRoom(String name, int rows, int columns) {
		Room newRoom = new Room(name, rows, columns);
		rooms.add(newRoom);
	}

	public Film addFilm(String name, int duration) {
		Film newFilm = new Film(name, duration);
		films.add(newFilm);
		return newFilm;
	}

	public void createCinemaFunction(String filmName, int filmDuration, GregorianCalendar d, int roomIndex) {
		Film f = addFilm(filmName, filmDuration);
		Room functionRoom = rooms.get(roomIndex);
		CinemaShow function = new CinemaShow(f, d, functionRoom);
		shows.add(function);
	}
	
	public void addSpectator(String name, String id) {
		Person newSpectator = new UniversityWalfarePerson(name, id);
		spectators.add(newSpectator);
	}

	public void addUWPerson(String name, String id) {
		UniversityWalfarePerson newUWPerson = new UniversityWalfarePerson(name, id);
		universityWPersons.add(newUWPerson);
	}

	public boolean logInUWPerson(String id) throws LogInException {
		boolean found = false;
		for (int i = 0; i < universityWPersons.size() - 1 && !found; i++) {
			found = universityWPersons.get(i).logIn(id);
		}
		if(!found) {
			throw new LogInException();
		}
		return found;	
	}

	public void readData() {
		//Create rooms
		buildRoom("Minisala", 4, 7);
		buildRoom("Sala media", 6, 7);
		
		GregorianCalendar date1 = new GregorianCalendar(2022, 3, 11, 10, 0);
		GregorianCalendar date2 = new GregorianCalendar(2022, 4, 11, 14, 0);
		createCinemaFunction("Harry Potter", 120, date1, 0);
		createCinemaFunction("Spiderman", 150, date1, 1);
		createCinemaFunction("James Bond", 100, date2, 0);
		createCinemaFunction("James Bond", 100, date2, 1);
		
		try {
			BufferedReader explorer = new BufferedReader(new FileReader("persons.txt"));
			String currentLine;

			while ((currentLine = explorer.readLine()) != null) {
				addUWPerson("UW", currentLine);
			}
			addUWPerson("UW", currentLine);
			explorer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reserveSeat(String spectatorName, String spectatorID, int showIndex, int seatRow, int seatColumn) {
		addSpectator(spectatorName, spectatorID);
		shows.get(showIndex).getRoom().reserveSeat(seatRow, seatColumn);
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public ArrayList<CinemaShow> getShows() {
		return shows;
	}
	
	public boolean[][] getReservedSeatsOfCinemaShow(int index) {
		return shows.get(index).getRoom().reservedSeats();
	}

	public ArrayList<UniversityWalfarePerson> getUniversityWPersons() {
		return universityWPersons;
	}
	
}
