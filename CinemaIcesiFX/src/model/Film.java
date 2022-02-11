package model;

public class Film {
	
	private String name;
	private int runningTime;
	
	public Film (String n, int time) {
		name = n;
		runningTime = time; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

}
