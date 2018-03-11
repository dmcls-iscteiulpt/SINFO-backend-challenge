package jUnitTests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Classes.Vehicle;

public class VehicleTest {

	private HashMap<String, String> hash = new HashMap<String, String>();
	
	@Test
	public void vehicleGetters() {
		hash.put("tuesday", "[\"1000\",\"1030\"]");
		Vehicle v = new Vehicle("1", "A", "ELECTRIC", "AUTO", hash );
		v.getId();
		v.getModel();
		v.getFuel();
		v.getTransmission();
		v.getAvailability();
		v.toString();
	}

}
