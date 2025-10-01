package org.example;

public class ScreenDemo {
	public static void main(String[] args) {

		// --- Initialize city data (Pakistan cities) ---
		CityCinema karachi = new CityCinema("Karachi", 2, 3);     // 2 cinemas, 3 screens each
		CityCinema lahore = new CityCinema("Lahore", 1, 2);       // 1 cinema, 2 screens
		CityCinema islamabad = new CityCinema("Islamabad", 2, 2); // 2 cinemas, 2 screens each

		// --- Display layouts for each city ---
		karachi.displayLayouts();
		lahore.displayLayouts();
		islamabad.displayLayouts();

		// --- Perform some operations to demo functionality ---
		System.out.println(">>> Booking a seat in Karachi, Cinema-1, Screen-1, Seat 3-007");
		boolean booked = karachi.book("Cinema-1", "Screen-1", "3-007");
		System.out.println("Booking success? " + booked);

		System.out.println("\n>>> Booking the same seat again (should fail)");
		boolean bookedAgain = karachi.book("Cinema-1", "Screen-1", "3-007");
		System.out.println("Booking success? " + bookedAgain);

		System.out.println("\n>>> Canceling the booking");
		boolean cancelled = karachi.cancel("Cinema-1", "Screen-1", "3-007");
		System.out.println("Cancel success? " + cancelled);

		// --- Show updated layout for Karachi after operations ---
		System.out.println("\nUpdated Layout for Karachi after booking/cancel operations:");
		karachi.displayLayouts();

		// --- City-wide stats ---
		System.out.println("City Stats:");
		System.out.println(karachi);
		System.out.println(lahore);
		System.out.println(islamabad);

		// --- Example: find first available VIP seat in Karachi ---
		System.out.println("\nFinding first available VIP seat in Karachi:");
		String vipSeat = karachi.findFirstAvailablePretty(Seat.SeatType.VIP);
		System.out.println(vipSeat != null ? vipSeat : "No VIP seat available.");
	}
}
