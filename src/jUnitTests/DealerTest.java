package jUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Classes.Dealer;
import Classes.Vehicle;

public class DealerTest {
	
	List<Vehicle> vehicles = new ArrayList<Vehicle>();
	List<String> days = new ArrayList<String>();
	@Test
	public void dealerGetters() {
		Dealer dealer = new Dealer("1234", "MB Braga", 42.156287, -8.645977, vehicles, days);
		dealer.getId();
		dealer.getName();
		dealer.getLatitude();
		dealer.getLongitude();
		dealer.getVehicles();
		dealer.getDays();
		dealer.toString();
	}

}
