package model;

import java.util.ArrayList;

public class Room {
	
	private String name;
	private boolean full;
	private Seat seats[][];
	private ArrayList<CinemaShow> shows;
	
	public Room(String name, int rows, int columns) {
		this.name = name;
		seats = new Seat[rows][columns];
		full = false;
		shows = new ArrayList<>();
	}
	
	public String reserveSeat(int row, int column) {
		String message = "Seat reserved";
		try {
			if(seats[row-1][column-1].isReserved()) {
				message = "Sorry, that seat has been already reserved before";
			}else {
				seats[row-1][column-1].setReserved(true);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			message = "That seat does not exist";
		}
		return message;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public boolean isFull() {
		return full;
	}
	
	public ArrayList<CinemaShow> getShows(){
		return shows;
	}
	
	
}
