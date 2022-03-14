package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CinemaShow implements Serializable {
	
	
	private Film film;
	private GregorianCalendar date;
	private Room room;
	
	private ArrayList<Person> viewers;
	
	public CinemaShow(Film f, GregorianCalendar d, Room r) {
		film = f;
		date = d;
		room = new Room(r.getName(), r.getSeats().length, r.getSeats()[0].length);
		viewers = new ArrayList<>();
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
		
		return   film.getName() + " - Day:" +  + day + " Month:" + month + " Time:" + hour + ":" +  minutes + " - " + room.getName();
	}

	public ArrayList<Person> getViewers() {
		return viewers;
	}
	
	public void addViewer(String id, String name) {
		viewers.add(new Person(name, id));
	}
	
	public String showReport() {
		String report = toString();
		if(viewers != null) {
			for (int i = 0; i < viewers.size(); i++) {
				report += "\n " + viewers.get(i).getName() + "\n";
			}	
		}
		
		return report;
	}
	
}
