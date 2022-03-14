package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CinemaShow {
	
	private Film film;
	private GregorianCalendar date;
	private Room room;
	
	public CinemaShow(Film f, GregorianCalendar d, Room r) {
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

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int minutes = date.get(Calendar.MINUTE);
		
		return   film.getName() + " Day:" +  + day + " Month:" + month + " Time:" + hour + ":" +  minutes + " " + room.getName();
	}
}
