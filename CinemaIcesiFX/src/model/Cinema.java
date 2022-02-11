//University Welfare
package model;

import java.util.ArrayList;
import java.util.Date;

public class Cinema {

	private ArrayList<Room> rooms;
	private ArrayList<Film> films;
	private ArrayList<CinemaShow> shows;

	public Cinema() {
		rooms = new ArrayList<>();
		buildRoom("mini", 4, 7);
		buildRoom("medium", 6, 7);

		films = new ArrayList<>();
		shows = new ArrayList<>();
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
		CinemaShow function =  new CinemaShow(f, d, r);
		shows.add(function);
	}

}
