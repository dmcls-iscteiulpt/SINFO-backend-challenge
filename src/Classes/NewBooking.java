package Classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class represents a booking creation
 * 
 * @author diana
 **/

public class NewBooking {

	private ReadFile rf;
	private List<Booking> bookingList = new ArrayList<Booking>();
	private String firstName;
	private String lastName;
	private String vehicleId;
	private LocalDateTime pickupDate;
	private JSONObject jsonFile;

	public NewBooking(ReadFile rf, String firstName, String lastName, String vehicleId, String pickupDate) {
		this.rf = rf;
		bookingList = rf.getBookingList();
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicleId = vehicleId;
		this.pickupDate = LocalDateTime.parse(pickupDate);
		createBooking();
	}

	/**
	 * This method checks if the booking can be created. The same vehicle can't
	 * be booked for the same time slot.
	 * 
	 **/

	public boolean createBooking() {
		for (int i = 0; i < bookingList.size(); i++) {
			if (bookingList.get(i).getVehicleId().equals(vehicleId)) {
				if (bookingList.get(i).getPickupDate().equals(pickupDate)) {
					System.out.println("Can't create booking because this vehicle has already one");
					return false;
				}
			}
		}
		String id = generateId();
		Booking booking = new Booking(id, firstName, lastName, vehicleId, pickupDate, LocalDateTime.now());

		addBooking(booking);
		return true;
	}

	/**
	 * This method adds a new booking to the .json file
	 * 
	 **/

	private void addBooking(Booking booking) {
		JSONParser parser = new JSONParser();
		JSONObject jsonBooking = new JSONObject();
		jsonBooking.put("id", booking.getId());
		jsonBooking.put("firstName", firstName);
		jsonBooking.put("lastName", lastName);
		jsonBooking.put("vehicleId", vehicleId);
		jsonBooking.put("pickupDate", pickupDate.toString());
		jsonBooking.put("createdAt", booking.getCreatedAt().toString());

		try {
			Object obj = parser.parse(new FileReader("./src/dataset.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray bookings = (JSONArray) jsonObject.get("bookings");
			bookings.add(jsonBooking);
			JSONArray dealers = (JSONArray) jsonObject.get("dealers");

			jsonFile = new JSONObject();
			jsonFile.put("dealers", dealers);
			jsonFile.put("bookings", bookings);

			FileWriter fw = new FileWriter("./src/dataset.json");
			fw.write(jsonFile.toJSONString());
			fw.flush();
			fw.close();
			System.out.println("Booking made!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method generates a random booking id
	 * 
	 **/
	private String generateId() {
		Random r = new Random(); 

		String alphabet = "1234567890qwertyuiopasdfghjklzxcvbnm";
		int idInicial = r.nextInt(10);
		String id = Integer.toString(idInicial);

		for (int i = 0; i < 31; i++) {
			id += alphabet.charAt(r.nextInt(alphabet.length()));
			if (i == 6 || i == 10 || i == 14 || i == 18) {
				id += "-";
			}
		}
		for (int j = 0; j < bookingList.size(); j++) {
			if (bookingList.get(j).getId() == id) {
				generateId();
			}
		}
		return id;
	}

}
