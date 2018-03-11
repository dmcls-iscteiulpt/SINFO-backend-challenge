package jUnitTests;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class BookingTest {

	@Test
	public void testBooking() {
		Classes.Booking booking = new Classes.Booking(null, null, null, null, null, null);
		Classes.Booking booking2 = new Classes.Booking(null, null, null, null, null, null, null, null);
		String id = booking.getId();
		String fN = booking.getFirstName();
		String lN = booking.getLastName();
		String vI = booking.getVehicleId();
		LocalDateTime pD = booking.getPickupDate();
		LocalDateTime crA = booking.getCreatedAt();
		DateTimeFormatter cA = booking.getCancelledAt();
		String cR = booking.getCancelledReason();
	
	}

}
