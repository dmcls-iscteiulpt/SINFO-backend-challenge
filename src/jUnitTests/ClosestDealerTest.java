package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.ClosestDealer;
import Classes.OrderVehicles;
import Classes.ReadFile;

public class ClosestDealerTest {

	@Test
	public void moreThanOneDealerFoundFirst() {
		ReadFile rf = new ReadFile();
		rf.readFile("./src/dataset.json");
		OrderVehicles ov = new OrderVehicles(rf);
		new ClosestDealer(ov,  "E", "ELECTRIC", "AUTO",37.156287, -8.645977);
	}
	
	@Test
	public void moreThanOneDealerFound() {
		ReadFile rf = new ReadFile();
		rf.readFile("./src/dataset.json");
		OrderVehicles ov = new OrderVehicles(rf);
		new ClosestDealer(ov,  "E", "ELECTRIC", "AUTO",47.156287, -8.645977);
	}
	
	@Test
	public void oneDealer() {
		ReadFile rf = new ReadFile();
		rf.readFile("./src/dataset.json");
		OrderVehicles ov = new OrderVehicles(rf);
		new ClosestDealer(ov,  "AMG", "GASOLINE", "MANUAL",37.156287, -8.645977);
	}

	@Test
	public void noDealer() {
		ReadFile rf = new ReadFile();
		rf.readFile("./src/dataset.json");
		OrderVehicles ov = new OrderVehicles(rf);
		new ClosestDealer(ov,  "A", "ELECTRIC", "MANUAL",37.156287, -8.645977);
	}
}
