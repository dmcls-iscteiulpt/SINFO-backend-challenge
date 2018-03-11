package Classes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents the Booking
 * 
 * @author diana
 * **/
public class Booking {

	private String id;
	private String vehicleId;
	private String firstName;
	private String lastName;
	private LocalDateTime pickupDate;
	private LocalDateTime createdAt;
	private DateTimeFormatter cancelledAt;
	private String cancelledReason;

	public Booking(String id, String firstName, String lastName, String vehicleId, LocalDateTime bookingPickupDate,
			LocalDateTime bookingCreatedAt, DateTimeFormatter cancelledAt, String cancelledReason) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicleId = vehicleId;
		this.pickupDate = bookingPickupDate;
		this.createdAt = bookingCreatedAt;
		this.cancelledAt = cancelledAt;
		this.cancelledReason = cancelledReason;
	}

	public Booking(String id, String firstName, String lastName, String vehicleId, LocalDateTime bookingPickupDate,
			LocalDateTime bookingCreatedAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicleId = vehicleId;
		this.pickupDate = bookingPickupDate;
		this.createdAt = bookingCreatedAt;
	}

	public String getId() {
		return id;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDateTime getPickupDate() {
		return pickupDate;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public DateTimeFormatter getCancelledAt() {
		return cancelledAt;
	}

	public String getCancelledReason() {
		return cancelledReason;
	}

}
