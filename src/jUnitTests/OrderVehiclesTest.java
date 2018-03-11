package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.OrderVehicles;
import Classes.ReadFile;

public class OrderVehiclesTest {
	ReadFile rf = new ReadFile();

	@Test
	public void testOrderVehicles(){
		rf.readFile("./src/dataset.json");
		OrderVehicles ov = new OrderVehicles(rf);
		ov.orderVehiclesByModel("A");
		ov.orderVehiclesByModel("B");
		ov.getVehiclesByModel("A");
		ov.getVehiclesByModel("B");
		ov.orderVehiclesByFuel("ELECTRIC");
		ov.orderVehiclesByFuel("GASOLEO");
		ov.getVehiclesByFuel("ELECTRIC");
		ov.getVehiclesByFuel("GAS");
		ov.orderVehiclesByTransmission("MANUAL");
		ov.orderVehiclesByTransmission("AUTOMATIC");
		ov.getVehiclesByTransmission("AUTO");
		ov.getVehiclesByTransmission("MAN");
		ov.orderVehiclesByDealer("MB Porto");
		ov.orderVehiclesByDealer("MB Braga");
	}

}