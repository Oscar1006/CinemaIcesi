package model;

import java.util.Calendar;

public class CinemaShow {
	
	private Film film;
	private Calendar date;
	private Room room;
	
	public CinemaShow(Film f, Calendar d, Room r) {
		film = f;
		date = d;
		room = r;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
