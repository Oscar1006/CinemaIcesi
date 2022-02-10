package model;

public class Seat {
	
	private boolean reserved;
	
	public Seat() {
		reserved = false;
	}
	
	public Seat (boolean r) {
		reserved = r;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean r) {
		reserved = r;
	}
	

}
