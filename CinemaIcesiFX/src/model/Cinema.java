//University Welfare
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import exception.LogInException;

public class Cinema {

	private ArrayList<Room> rooms;
	private ArrayList<Film> films;
	private ArrayList<CinemaShow> shows;
	private ArrayList<UniversityWalfarePerson> universityWPersons;

	public Cinema() {
		rooms = new ArrayList<>();
		films = new ArrayList<>();
		shows = new ArrayList<>();
		universityWPersons = new ArrayList<>();
		readData();
	}

	public void buildRoom(String name, int rows, int columns) {
		Room newRoom = new Room(name, rows, columns);
		rooms.add(newRoom);
	}

	public void addFilm(String name, int duration) {
		Film newFilm = new Film(name, duration);
		films.add(newFilm);
	}

	public void createCinemaFunction(Film f, Date d, Room r) {
		CinemaShow function = new CinemaShow(f, d, r);
		shows.add(function);
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
		//Crear data de las salas
		buildRoom("Minisala", 4, 7);
		buildRoom("Sala media", 6, 7);
		
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

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public ArrayList<CinemaShow> getShows() {
		return shows;
	}

	public ArrayList<UniversityWalfarePerson> getUniversityWPersons() {
		return universityWPersons;
	}
	

}
