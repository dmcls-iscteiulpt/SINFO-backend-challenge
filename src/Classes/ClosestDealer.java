package Classes;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the closest dealer according to vehicle's atributes
 * 
 * @author diana
 **/

public class ClosestDealer {

	private OrderVehicles ov;
	private double longitude;
	private double latitude;

	public ClosestDealer(OrderVehicles ov, String model, String fuel, String transmission, double latitude,
			double longitude) {
		this.ov = ov;
		this.latitude = latitude;
		this.longitude = longitude;
		searchDealer(model, fuel, transmission);
	}

	/**
	 * This method tries to find if there is a vehicle with the given
	 * atributtes. If there is one, returns the respective dealer. If there are
	 * two vehicles, this method calculates and returns the closest dealer.
	 * 
	 **/
	public void searchDealer(String model, String fuel, String transmission) {
		Dealer closestDealer = null;
		int earthRadius = 6371;
		double closestDistance = 0.0;
		List<Dealer> dealerVehicleList = new ArrayList<Dealer>();
		List<Vehicle> modelVehicles = ov.getVehiclesByModel(model);
		List<Vehicle> fuelVehicles = ov.getVehiclesByFuel(fuel);
		List<Vehicle> transmissionVehicles = ov.getVehiclesByTransmission(transmission);
		List<Vehicle> auxList = new ArrayList<Vehicle>();
		List<Vehicle> finalList = new ArrayList<Vehicle>();

		for (int i = 0; i < modelVehicles.size(); i++) {
			if (fuelVehicles.contains(modelVehicles.get(i))) {
				auxList.add(modelVehicles.get(i));
			}
		}

		for (int j = 0; j < transmissionVehicles.size(); j++) {
			if (auxList.contains(transmissionVehicles.get(j))) {
				finalList.add(transmissionVehicles.get(j));
			}
		}
		if (finalList.isEmpty()) {

			System.out.println("0: There is no car with those attributes");

		} else if (finalList.size() == 1) {

			Dealer d = ov.getCarToDealer(finalList.get(0));
			System.out.println(d.getName());

		} else {
			for (int k = 0; k < finalList.size(); k++) {
				dealerVehicleList.add(ov.getCarToDealer(finalList.get(k)));
			}

			for (int m = 0; m < dealerVehicleList.size(); m++) {
				double lat = dealerVehicleList.get(m).getLatitude();
				double lon = dealerVehicleList.get(m).getLongitude();

				double latDistance = Math.toRadians(latitude - lat);
				double lonDistance = Math.toRadians(longitude - lon);
				double dist = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat))
						* Math.cos(Math.toRadians(latitude)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
				double angle = 2 * Math.atan2(Math.sqrt(dist), Math.sqrt(1 - dist));
				double distance = Math.sqrt(earthRadius * angle * 1000);

				if (m == 0) {
					closestDistance = distance;
					closestDealer = dealerVehicleList.get(0);
				} else if (distance < closestDistance) {
					closestDistance = distance;
					closestDealer = dealerVehicleList.get(m);
				}
			}
			System.out.println("Closest dealer: " + closestDealer.getName());

		}
	}

}