package Classes;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class represents the booking cancellation
 * 
 * @author diana
 **/

public class CancelBooking {

	private ReadFile rf;
	private Booking cancelledBooking;
	private List<Booking> bookingList = new ArrayList<Booking>();
	private JSONObject jsonFile;
	
	/**
	 * This constructor checks if there is a reason to cancel the booking
	 * 
	 **/
	public CancelBooking(ReadFile rf, String id, String cancelledReason) {
		this.rf = rf;
		bookingList = rf.getBookingList();
		if(cancelledReason == null || cancelledReason.equals("")){
			System.out.println("Give a reason to cancel the booking");
		}else{
			if(confirmBooking(id)){
				deleteBooking();
			}
		}
	}
	
	/**
	 * This method checks if the vehicle is available for booking
	 * 
	 **/
	
	public boolean confirmBooking(String id){
		
		for(int i = 0; i < bookingList.size(); i++){
			if(id.equals(bookingList.get(i).getId())){
				cancelledBooking = bookingList.get(i);
				return true;
			}
		}
		System.out.println("That booking doesn't exist");
		return false;
	}
	
	/**
	 * This method deletes the booking from the .json file
	 * 
	 **/
	
	private void deleteBooking() {
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("./src/dataset.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray bookings = (JSONArray) jsonObject.get("bookings");
			bookings.remove(cancelledBooking);
			JSONArray dealers = (JSONArray) jsonObject.get("dealers");
			
			jsonFile = new JSONObject();
			jsonFile.put("dealers", dealers);
			jsonFile.put("bookings",bookings);
			
			FileWriter fw = new FileWriter("./src/dataset.json");
			fw.write(jsonFile.toJSONString());
			fw.flush();
			fw.close();
			System.out.println("Booking deleted!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
	}


}
