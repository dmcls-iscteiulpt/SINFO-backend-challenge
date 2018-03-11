package Classes;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class reads the content from .json file
 * 
 * @author diana
 * **/
public class ReadFile {
	private List<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private List<Dealer> dealerList = new ArrayList<Dealer>();
	private List<Booking> bookingList = new ArrayList<Booking>();

	/**
	 * This method reads .json file and writes to the vehicle's, dealer's and boooking's list.
	 * 
	 **/
	public void readFile(String filePath) {
		JSONParser parser = new JSONParser();
		Object object;
		try {
			object = parser.parse(new FileReader(filePath));
			JSONObject obj = (JSONObject) object;

			JSONArray bookingArray = (JSONArray) obj.get("bookings");
			for (int b = 0; b < bookingArray.size(); b++) {
				JSONObject bookingJO = (JSONObject) bookingArray.get(b);
				String bookingId = bookingJO.get("id").toString();
				String bookingFirstName = bookingJO.get("firstName").toString();
				String bookingLastName = bookingJO.get("lastName").toString();
				String bookingVehicleId = bookingJO.get("vehicleId").toString();
				String bookingPickupDateString = bookingJO.get("pickupDate").toString();
				LocalDateTime bookingPickupDate = LocalDateTime.parse(bookingPickupDateString);
				String bookingCreatedAtString = bookingJO.get("createdAt").toString();
				LocalDateTime bookingCreatedAt = LocalDateTime.parse(bookingCreatedAtString);
				bookingList.add(new Booking(bookingId, bookingFirstName, bookingLastName, bookingVehicleId,
						bookingPickupDate, bookingCreatedAt, null, null));
			}
			JSONArray array = (JSONArray) obj.get("dealers");
			for (int i = 0; i < array.size(); i++) {
				List<String> dealerClosed = new ArrayList<String>();
				JSONObject dealerJO = (JSONObject) array.get(i);

				String dealerId = dealerJO.get("id").toString();
				String dealerName = dealerJO.get("name").toString();
				String dealerLatitude = dealerJO.get("latitude").toString();
				String dealerLongitude = dealerJO.get("longitude").toString();
				JSONArray vehiclesArray = (JSONArray) dealerJO.get("vehicles");
				JSONArray daysClosed = (JSONArray) dealerJO.get("closed");

				for (int dc = 0; dc < daysClosed.size(); dc++) {
					dealerClosed.add(daysClosed.get(dc).toString());
				}

				List<Vehicle> tempList = new ArrayList<Vehicle>();
				for (int j = 0; j < vehiclesArray.size(); j++) {
					JSONObject vehicleObj = (JSONObject) vehiclesArray.get(j);
					String vehicleId = vehicleObj.get("id").toString();					
					String vehicleModel = vehicleObj.get("model").toString();
					String vehicleFuel = vehicleObj.get("fuel").toString();
					String vehicleTransmission = vehicleObj.get("transmission").toString();
					JSONObject vehicleAvailabilityJC = (JSONObject)vehicleObj.get("availability");
					HashMap<String, String> vehicleAvailability = new HashMap<String, String>();

					for (int l = 0; l < 7; l++) {
						String day = Days.values()[l].toString();
						if (vehicleAvailabilityJC.get(day) != null) {
							vehicleAvailability.put(day, vehicleAvailabilityJC.get(day).toString());
						}
					}
					tempList.add(new Vehicle(vehicleId, vehicleModel, vehicleFuel, vehicleTransmission,
							vehicleAvailability));
					vehicleList.add(new Vehicle(vehicleId, vehicleModel, vehicleFuel, vehicleTransmission,
							vehicleAvailability));
				}
				dealerList.add(new Dealer(dealerId, dealerName, Double.parseDouble(dealerLatitude),
						Double.parseDouble(dealerLongitude), tempList, dealerClosed));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public List<Dealer> getDealerList() {
		return dealerList;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

}
