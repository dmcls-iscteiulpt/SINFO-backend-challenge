package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.CancelBooking;
import Classes.ReadFile;

public class CancelBookingTest {
	ReadFile rf = new ReadFile();

	@Test
	public void cancelBookingTestNull() {
		new CancelBooking(new ReadFile(), null, null);
	}
	@Test
	public void cancelBookingTestValid(){
		rf.readFile("./src/dataset.json");
		new CancelBooking(rf, "1af767b7-89c0-424b-a414-bf44b218eb8a", "reason1");
	}
	
	@Test 
	public void cancelBookTestIdFail(){
		rf.readFile("./src/dataset.json");
		new CancelBooking(rf, "1af767b7-89c0-424b-a414-bf44b218ebad", "reason1");
	}

}
