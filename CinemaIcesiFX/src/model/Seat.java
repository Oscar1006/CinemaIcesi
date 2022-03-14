package model;

import java.io.Serializable;

public class Seat implements Serializable {
	
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
