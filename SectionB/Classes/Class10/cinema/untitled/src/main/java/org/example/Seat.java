package org.example;

public class Seat {


	public enum SeatType {
		REGULAR,
		PREMIUM,
		VIP,
		RECLINER
	}

	private String id;          // unique seat ID like "1-001"
	private SeatType seatType;
	private double price;
	private boolean isAvailable;

	// Default constructor
	public Seat() {
		this.isAvailable = true;
	}

	// Constructor with row, column, type, and price
	public Seat(int row, int col, SeatType seatType, double price) {
		this.id = String.format("%d-%03d", row, col);
		this.seatType = seatType;
		this.price = price;
		this.isAvailable = true; // new seat starts as available
	}

	// Getters
	public String getId() {
		return id;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public double getPrice() {
		return price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	// Setters
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// Booking functionality
	public boolean bookSeat() {
		if (isAvailable) {
			isAvailable = false;
			return true;
		}
		return false; // already booked
	}

	public boolean cancelBooking() {
		if (!isAvailable) {
			isAvailable = true;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Seat[ID=%s, Type=%s, Price=%.2f, Available=%s]",
				id, seatType, price, isAvailable ? "Yes" : "No");
	}
}
