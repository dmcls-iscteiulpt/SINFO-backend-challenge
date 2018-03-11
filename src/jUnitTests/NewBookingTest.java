package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.Booking;
import Classes.NewBooking;
import Classes.ReadFile;

public class NewBookingTest {

	@Test
	public void newBookingValid() {
		ReadFile rf = new ReadFile();
		new NewBooking(rf, "Diana", "Lopes", "44a36bfa-ec8f-4448-bas2-80ss03bdcb6e", "2018-04-05T10:00:00");
	}
	
	@Test
	public void newBookingFail() {
		ReadFile rf = new ReadFile();
		rf.readFile("./src/dataset.json");
		new NewBooking(rf, "Diana", "Lopes", "44a36bfa-ec8f-4448-b4c2-809203bdcb9e", "2018-03-03T10:30:00");
	}
	

}
