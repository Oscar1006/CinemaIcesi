package model;

import java.util.ArrayList;

public class Room {

	private String name;
	private boolean full;
	private Seat seats[][];
	private ArrayList<CinemaShow> shows;
	private int rows;
	private int columns;

	public Room() {
		
	}
	public Room(String name, int rows, int columns) {
		this.name = name;
		seats = new Seat[rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				seats[r][c] = new Seat();
			}
		}
		full = false;
		shows = new ArrayList<>();
		this.rows = rows;
		this.columns = columns;
	}
	

	public void reserveSeat(int row, int column) {
		if (!seats[row][column].isReserved()) {
			seats[row][column].setReserved(true);
		}
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
	
	public boolean[][] reservedSeats(){
		boolean[][] reservedSeats = new boolean[rows][columns];
		
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				reservedSeats[r][c] = seats[r][c].isReserved();
			}
		}
		
		return reservedSeats;
	}

	public boolean isFull() {
		int capacity = seats.length * seats[0].length;
		int reservedSeats = 0;
		for(int f = 0; f < seats.length-1; f++) {
			for(int c = 0; c < seats[f].length-1; c++) {
				if (seats[f][c].isReserved()) {
					reservedSeats++;
				}
			}
		}
		if(capacity == reservedSeats) {
			full = true;
		}
		return full;
	}

	public ArrayList<CinemaShow> getShows() {
		return shows;
	}

}
