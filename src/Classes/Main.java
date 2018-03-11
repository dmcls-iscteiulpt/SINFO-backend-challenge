package Classes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		rf.readFile("./src/dataset.json");
		
		//List vehicles by Model:
		OrderVehicles ov = new OrderVehicles(rf);
		ov.orderVehiclesByModel("A");
		ov.orderVehiclesByFuel("ELECTRIC");
		ov.orderVehiclesByTransmission("AUTO");
		ov.orderVehiclesByDealer("MB Albufeira");
		
		//Find the closest Dealer
		new ClosestDealer(ov,  "E", "ELECTRIC", "AUTO", 37.156287, -8.645977);
		
		//Create a new booking
		new NewBooking(rf,"Diana", "Lopes", "768a79af-4636-0751-b1bd-76bo900378ce", "2018-05-03T10:30:00");
		
		//Cancel a booking
		new CancelBooking(rf, "1c6bd910-12b1-45d6-b4d8-cdff2f37db90", "Reason1");
	}

}
