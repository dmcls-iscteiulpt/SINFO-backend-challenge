package Classes;
import java.util.List;

/**
 * This class represents the Dealer
 * 
 * @author diana
 * **/
public class Dealer {
	
	private String id;
	private String name;
	private double latitude;
	private double longitude;
	private List<Vehicle> vehicles;
	private List<String> days; 

	public Dealer(String id, String name, double latitude, double longitude,
			List<Vehicle> vehicles, List<String> days){	
		this.id=id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.vehicles = vehicles;
		this.days = days;
	}

	@Override
	public String toString() {
		return "Id: " + id + "\nName: " + name + "\nLatitude: " + latitude + "\nLongitude: " + longitude
				+ "\nVehicles: " + vehicles + "\nDays: " + days + "\n";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public List<String> getDays() {
		return days;
	}
	
}
