package model;

import static org.junit.Assert.*;
import org.junit.Test;

import exception.LogInException;
import exception.ReservedSeatException;


public class CinemaTest {
	
	private Cinema cine;
	
	private void setUpStage1() {
		cine = new Cinema();
	}
	private void setUpStage2() {
		cine = new Cinema();
		try {
			cine.reserveSeat("Ivan", "987654", 1, 1, 1);
		} catch (ReservedSeatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testLogInUWPerson() {
		setUpStage1();
		boolean passed= false;
		try {
			passed = cine.logInUWPerson("1006169163");
			
			
		} catch (LogInException e) {
			System.out.println(e.getMessage());
			fail("It should not throw exeption");
		}
		assertTrue("The person could not log in", passed);
	}
	
	@Test
	public void testLogInUWPerson2() {
		setUpStage1();
		boolean passed = false;
		try {
			passed = cine.logInUWPerson("4100003456");
			fail("It should throw exeption");
		} catch (LogInException e) {
			System.out.println(e.getMessage());
		}
		assertTrue("The person logged in", !passed);
	}
	
	@Test
	public void testReserveSeat() {
		setUpStage1();
		try {
			cine.reserveSeat("Oscar", "1234567", 1, 1, 1);
		}catch (ReservedSeatException e) {
			System.out.println(e.getMessage());
			fail("It should not throw exeption");
		}
		assertTrue("The seat has not been reserved", cine.getShow(1).getRoom().getSeat(1, 1).isReserved());
	}
	
	@Test
	public void testReserveSeat2() {
		setUpStage2();
		try {
			cine.reserveSeat("Oscar", "1234567", 1, 1, 1);
			fail("It should throw exeption");
		}catch (ReservedSeatException e) {
			System.out.println(e.getMessage());
		}
		boolean isReservedByOscar = false;
		for (int i = 0; i < cine.getShow(1).getViewers().size(); i++) {
			if (cine.getShow(1).getViewers().get(i).getName().equalsIgnoreCase("1234567")) {
				isReservedByOscar = true;
			}
		}
		assertTrue("The seat was reserved by Oscar", !isReservedByOscar);
	}

}
