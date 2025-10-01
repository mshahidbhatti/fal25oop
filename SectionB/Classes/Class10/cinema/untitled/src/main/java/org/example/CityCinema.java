package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CityCinema {

	private final String cityName;
	private final List<Cinema> cinemas = new ArrayList<>();

	// -------------------- Constructors --------------------

	/** Empty city with a name; add cinemas later. */
	public CityCinema(String cityName) {
		if (cityName == null || cityName.isBlank()) {
			throw new IllegalArgumentException("City name must not be empty.");
		}
		this.cityName = cityName.trim();
	}

	/**
	 * Preloaded city:
	 * Creates N cinemas named "Cinema-1..N", each with S default-config screens.
	 * Each screen uses the Screen default row layout (e.g., 10..14) and SeatType/price policy.
	 */
	public CityCinema(String cityName, int numCinemas, int screensPerCinema) {
		this(cityName);
		if (numCinemas <= 0 || screensPerCinema <= 0) {
			throw new IllegalArgumentException("numCinemas and screensPerCinema must be positive.");
		}
		for (int i = 1; i <= numCinemas; i++) {
			cinemas.add(new Cinema("Cinema-" + i, screensPerCinema));
		}
	}

	// -------------------- Basic getters --------------------

	public String getCityName() {
		return cityName;
	}

	public int getCinemaCount() {
		return cinemas.size();
	}

	public List<Cinema> getCinemas() {
		return Collections.unmodifiableList(cinemas);
	}

	// -------------------- Manage cinemas --------------------

	public void addCinema(Cinema cinema) {
		Objects.requireNonNull(cinema, "cinema must not be null");
		if (findCinemaByName(cinema.getName()) != null) {
			throw new IllegalArgumentException("Cinema '" + cinema.getName() + "' already exists in " + cityName);
		}
		cinemas.add(cinema);
	}

	/** Convenience factory: add new cinema with default screens. */
	public Cinema addCinema(String cinemaName, int screens) {
		Cinema c = new Cinema(cinemaName, screens);
		addCinema(c);
		return c;
	}

	public boolean removeCinemaByName(String cinemaName) {
		Cinema c = findCinemaByName(cinemaName);
		return c != null && cinemas.remove(c);
	}

	public Cinema findCinemaByName(String cinemaName) {
		if (cinemaName == null) return null;
		for (Cinema c : cinemas) {
			if (cinemaName.equalsIgnoreCase(c.getName())) return c;
		}
		return null;
	}

	// -------------------- Booking / Cancellation --------------------
	// Route: City -> Cinema -> Screen -> Seat

	/** Book by cinema name, screen name, and seat ID (e.g., "3-007"). */
	public boolean book(String cinemaName, String screenName, String seatId) {
		Cinema c = requireCinema(cinemaName);
		return c.book(screenName, seatId);
	}

	/** Cancel by cinema name, screen name, and seat ID. */
	public boolean cancel(String cinemaName, String screenName, String seatId) {
		Cinema c = requireCinema(cinemaName);
		return c.cancel(screenName, seatId);
	}

	// -------------------- Aggregated metrics (city-wide) --------------------

	public int getTotalSeatCount() {
		int total = 0;
		for (Cinema c : cinemas) total += c.getTotalSeatCount();
		return total;
	}

	public int getAvailableSeatCount() {
		int total = 0;
		for (Cinema c : cinemas) total += c.getAvailableSeatCount();
		return total;
	}

	public int getAvailableSeatCount(Seat.SeatType type) {
		int total = 0;
		for (Cinema c : cinemas) total += c.getAvailableSeatCount(type);
		return total;
	}

	// -------------------- Search helpers --------------------

	/**
	 * Find the first available seat of a given type anywhere in the city.
	 * Returns a human-friendly descriptor like:
	 * "Cinema-2 > Screen-1 > Seat 3-007 (VIP, 1000.00)"
	 * or null if none is found.
	 */
	public String findFirstAvailablePretty(Seat.SeatType type) {
		for (Cinema c : cinemas) {
			for (Screen s : c.getScreens()) {
				Seat seat = s.findFirstAvailable(type);
				if (seat != null) {
					return String.format("%s > %s > Seat %s (%s, %.2f)",
							c.getName(), s.getScreenName(), seat.getId(), seat.getSeatType(), seat.getPrice());
				}
			}
		}
		return null;
	}

	/**
	 * List all available seats of a given type for a specific cinema.
	 * Returns an unmodifiable copy (safe to expose).
	 */
	public List<Seat> listAvailable(String cinemaName, Seat.SeatType type) {
		Cinema c = requireCinema(cinemaName);
		List<Seat> out = new ArrayList<>();
		for (Screen s : c.getScreens()) {
			out.addAll(s.listAvailable(type));
		}
		return Collections.unmodifiableList(out);
	}

	// -------------------- Displays / Reports --------------------

	/** Compact layouts for every cinema (delegates down to each screen). */
	public void displayLayouts() {
		System.out.println("=== CITY: " + cityName + " | All Cinema Layouts ===");
		for (Cinema c : cinemas) {
			c.displayLayout();
			System.out.println("=======================================");
		}
		System.out.printf("City Totals -> Seats: %d, Available: %d%n",
				getTotalSeatCount(), getAvailableSeatCount());
		System.out.println();
	}

	/** Verbose seat listings for every cinema. */
	public void displayVerbose() {
		System.out.println("=== CITY: " + cityName + " | Detailed Seats ===");
		for (Cinema c : cinemas) {
			c.displayVerbose();
			System.out.println("=======================================");
		}
		System.out.printf("City Totals -> Seats: %d, Available: %d%n",
				getTotalSeatCount(), getAvailableSeatCount());
		System.out.println();
	}

	@Override
	public String toString() {
		return String.format("CityCinema{city='%s', cinemas=%d, totalSeats=%d, available=%d}",
				cityName, getCinemaCount(), getTotalSeatCount(), getAvailableSeatCount());
	}

	// -------------------- Sample data loader (arrays) --------------------
	/**
	 * OPTIONAL: If you need a strict array-based preload (e.g., for a lab requirement),
	 * this method populates the city with a fixed array of cinemas/screens layout.
	 * Example: 2 cinemas × 3 screens each, with jagged rows {10,11,12,13,14}.
	 */
	public void loadSampleDataUsingArrays() {
		Cinema[] preset = new Cinema[2];
		for (int i = 0; i < preset.length; i++) {
			preset[i] = new Cinema("Cinema-" + (i + 1), 3); // each cinema preloads 3 screens by default
		}
		// Move array elements into our managed list (avoids exposing raw arrays externally)
		cinemas.clear();
		Collections.addAll(cinemas, preset);
	}

	// -------------------- Helpers --------------------

	private Cinema requireCinema(String name) {
		Cinema c = findCinemaByName(name);
		if (c == null) {
			throw new IllegalArgumentException("No cinema named '" + name + "' in city '" + cityName + "'.");
		}
		return c;
	}
}
