package Classes;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a vehicle
 * 
 * @author diana
 * **/
public class Vehicle {

	private String id;
	private String model;
	private String fuel;
	private String transmission;
	private HashMap<String, String> availability;

	public Vehicle(String id, String model, String fuel, String transmission, HashMap<String, String> availability) {
		this.id = id;
		this.model = model;
		this.fuel = fuel;
		this.transmission = transmission;
		this.availability = formatAvailability(availability);
	}

	private HashMap<String, String> formatAvailability(HashMap<String, String> availabilityHash) {
		HashMap<String, String> hash = new HashMap<String, String>();
		for (Map.Entry me : availabilityHash.entrySet()) {
			String[] numbers = me.getValue().toString().replace("\"", "").replace("[", "").replace("]", "").replace(",", "-").split("-");
			String inicialHourDivision = numbers[0];
			String finalHourDivision = numbers[1];
	
			String inicialHour = inicialHourDivision.substring(0, 2) + "h" + inicialHourDivision.substring(2,inicialHourDivision.length()); 
			String finalHour = finalHourDivision.substring(0, 2) + "h" + finalHourDivision.substring(2,finalHourDivision.length());
			String hours = inicialHour + "-" + finalHour;
			hash.put(me.getKey().toString(), hours);
		}
		return hash;
	}

	public String getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getFuel() {
		return fuel;
	}

	public String getTransmission() {
		return transmission;
	}

	public HashMap<String, String> getAvailability() {
		return availability;
	}

	@Override
	public String toString() {
		return "\nNumber: " + id + "\nModel: " + model + "\nFuel: " + fuel + "\nTransmission: " + transmission
				+ "\nAvailability: " + availability + "\n";
	}
}
