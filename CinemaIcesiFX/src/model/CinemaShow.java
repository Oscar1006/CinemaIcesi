package model;

import java.util.Date;

public class CinemaShow {
	
	private Film film;
	private Date date;
	private Room room;
	
	public CinemaShow(Film f, Date d, Room r) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	

}
