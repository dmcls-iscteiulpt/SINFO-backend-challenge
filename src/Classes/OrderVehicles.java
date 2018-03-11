package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * This class order vehicles by model, fuel, transmission and deal
 * 
 * @author diana
 **/
public class OrderVehicles {

	private ReadFile rf = new ReadFile();
	private List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
	private List<Dealer> dealerList = new ArrayList<Dealer>();

	public OrderVehicles(ReadFile rf) {
		this.rf = rf;
		vehiclesList = rf.getVehicleList();
		dealerList = rf.getDealerList();
	}

	/**
	 * This method returns the vehicles with a specific model
	 * 
	 **/
	public void orderVehiclesByModel(String model) {
		int count = 0;
		for (int i = 0; i < vehiclesList.size(); i++) {
			if (vehiclesList.get(i).getModel().equals(model)) {
				if (count == 0) {
					System.out.println("Vehicles listed by model: " + model);
				}
				System.out.println(vehiclesList.get(i).toString());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("There are no models named " + model);
		}
	}

	/**
	 * This method writes to the vehicle's list: vehicleListByModel, the
	 * vehicles with the given model
	 * 
	 **/
	public List<Vehicle> getVehiclesByModel(String model) {
		List<Vehicle> vehicleListByModel = new ArrayList<Vehicle>();
		for (int i = 0; i < vehiclesList.size(); i++) {
			if (vehiclesList.get(i).getModel().equals(model)) {
				vehicleListByModel.add(vehiclesList.get(i));
			}
		}
		return vehicleListByModel;
	}

	/**
	 * This method returns the vehicles with a specific fuel
	 * 
	 **/
	public void orderVehiclesByFuel(String fuel) {
		int count = 0;
		for (int i = 0; i < vehiclesList.size(); i++) {
			if (vehiclesList.get(i).getFuel().equals(fuel)) {
				if (count == 0) {
					System.out.println("Vehicles listed by fuel: " + fuel);
				}
				System.out.println(vehiclesList.get(i).toString());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("There is no fuel type named " + fuel);
		}

	}

	/**
	 * This method writes to the vehicle's list: vehicleListByFuel, the vehicles
	 * with the given fuel
	 * 
	 **/
	public List<Vehicle> getVehiclesByFuel(String fuel) {
		List<Vehicle> vehicleListByFuel = new ArrayList<Vehicle>();
		for (int i = 0; i < vehiclesList.size(); i++) {
			if (vehiclesList.get(i).getFuel().equals(fuel)) {
				vehicleListByFuel.add(vehiclesList.get(i));
			}
		}
		return vehicleListByFuel;

	}

	/**
	 * This method returns the vehicles with a specific transmission
	 * 
	 **/
	public void orderVehiclesByTransmission(String transmission) {
		int count = 0;
		for (int i = 0; i < vehiclesList.size(); i++) {
			if (vehiclesList.get(i).getTransmission().equals(transmission)) {
				if (count == 0) {
					System.out.println("Vehicles listed by transmission: " + transmission);
				}
				System.out.println(vehiclesList.get(i).toString());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("There is no " + transmission + " transmission type");
		}
	}

	/**
	 * This method writes to the vehicle's list: vehicleListByTransmission, the
	 * vehicles with the given transmission
	 * 
	 **/
	public List<Vehicle> getVehiclesByTransmission(String transmission) {
		List<Vehicle> vehicleListByTransmission = new ArrayList<Vehicle>();
		for (int i = 0; i < vehiclesList.size(); i++) {
			if (vehiclesList.get(i).getTransmission().equals(transmission)) {
				vehicleListByTransmission.add(vehiclesList.get(i));
			}
		}
		return vehicleListByTransmission;
	}

	/**
	 * This method returns the vehicle list of a dealer
	 * 
	 **/
	public void orderVehiclesByDealer(String dealer) {
		List<Vehicle> vehicleListByDealer = new ArrayList<Vehicle>();
		int count = 0;
		for (int i = 0; i < dealerList.size(); i++) {
			if (dealerList.get(i).getName().equals(dealer)) {
				if(count == 0){
					System.out.println("Vehicles listed by dealer: " + dealer);
				}
				vehicleListByDealer = dealerList.get(i).getVehicles();
				count++;
			}
		}
		if (count != 0) {
			for (int j = 0; j < vehicleListByDealer.size(); j++) {
				System.out.println(vehicleListByDealer.get(j).toString());
			}
		} else {
			System.out.println("There is no dealer named " + dealer);
		}
	}

	/**
	 * This method returns the vehicle's list of the given dealer
	 * 
	 **/
	public List<Vehicle> getVehiclesByDealer(String dealer) {
		List<Vehicle> vehicleListByDealer = new ArrayList<Vehicle>();
		for (int i = 0; i < dealerList.size(); i++) {
			if (dealerList.get(i).getName().equals(dealer)) {
				vehicleListByDealer = dealerList.get(i).getVehicles();
			}
		}
		for (int j = 0; j < vehicleListByDealer.size(); j++) {
			vehicleListByDealer.add(vehicleListByDealer.get(j));
		}
		return vehicleListByDealer;
	}

	/**
	 * This method returns the dealer that has the given vehicle
	 * 
	 **/
	public Dealer getCarToDealer(Vehicle vehicle) {
		Dealer dealer = null;
		for (int i = 0; i < dealerList.size(); i++) {
			for (int j = 0; j < dealerList.get(i).getVehicles().size(); j++) {
				if (dealerList.get(i).getVehicles().get(j).getId().equals(vehicle.getId())) {
					dealer = dealerList.get(i);
				}
			}
		}
		return dealer;
	}

	public ReadFile getRf() {
		return rf;
	}

}
