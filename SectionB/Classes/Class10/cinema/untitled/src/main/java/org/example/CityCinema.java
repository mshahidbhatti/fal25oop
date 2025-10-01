package org.example;

public class CityCinema {

	private final String cityName;

	// Backing array + logical size (arrays-only, grow manually)
	private Cinema[] cinemas;
	private int cinemaCount;

	// -------------------- Constructors --------------------

	/** Empty city with a name; add cinemas later. */
	public CityCinema(String cityName) {
		if (cityName == null || cityName.trim().isEmpty()) {
			throw new IllegalArgumentException("City name must not be empty.");
		}
		this.cityName = cityName.trim();
		this.cinemas = new Cinema[4]; // initial capacity
		this.cinemaCount = 0;
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
		ensureCapacity(numCinemas);
		for (int i = 1; i <= numCinemas; i++) {
			cinemas[cinemaCount++] = new Cinema("Cinema-" + i, screensPerCinema);
		}
	}

	// -------------------- Basic getters --------------------

	public String getCityName() {
		return cityName;
	}

	public int getCinemaCount() {
		return cinemaCount;
	}

	/** Returns a copy of the used portion of the cinemas array. */
	public Cinema[] getCinemas() {
		Cinema[] copy = new Cinema[cinemaCount];
		for (int i = 0; i < cinemaCount; i++) copy[i] = cinemas[i];
		return copy;
	}

	// -------------------- Manage cinemas --------------------

	public void addCinema(Cinema cinema) {
		if (cinema == null) throw new IllegalArgumentException("cinema must not be null");
		if (findCinemaByName(cinema.getName()) != null) {
			throw new IllegalArgumentException("Cinema '" + cinema.getName() + "' already exists in " + cityName);
		}
		ensureCapacity(cinemaCount + 1);
		cinemas[cinemaCount++] = cinema;
	}

	/** Convenience factory: add new cinema with default screens. */
	public Cinema addCinema(String cinemaName, int screens) {
		Cinema c = new Cinema(cinemaName, screens);
		addCinema(c);
		return c;
	}

	public boolean removeCinemaByName(String cinemaName) {
		int idx = indexOfCinema(cinemaName);
		if (idx == -1) return false;
		// shift left
		for (int i = idx; i < cinemaCount - 1; i++) {
			cinemas[i] = cinemas[i + 1];
		}
		cinemas[--cinemaCount] = null; // help GC
		return true;
	}

	public Cinema findCinemaByName(String cinemaName) {
		int idx = indexOfCinema(cinemaName);
		return (idx == -1) ? null : cinemas[idx];
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
		for (int i = 0; i < cinemaCount; i++) total += cinemas[i].getTotalSeatCount();
		return total;
	}

	public int getAvailableSeatCount() {
		int total = 0;
		for (int i = 0; i < cinemaCount; i++) total += cinemas[i].getAvailableSeatCount();
		return total;
	}

	public int getAvailableSeatCount(Seat.SeatType type) {
		int total = 0;
		for (int i = 0; i < cinemaCount; i++) total += cinemas[i].getAvailableSeatCount(type);
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
		for (int i = 0; i < cinemaCount; i++) {
			Cinema c = cinemas[i];
			int screenCount = c.getScreenCount();
			for (int sIdx = 0; sIdx < screenCount; sIdx++) {
				Screen s = c.getScreen(sIdx);
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
	 * List all available seats of a given type for a specific cinema as a plain array.
	 * Arrays-only approach: two passes (count, then fill).
	 */
	public Seat[] listAvailable(String cinemaName, Seat.SeatType type) {
		Cinema c = requireCinema(cinemaName);

		// 1) Count
		int total = 0;
		int screenCount = c.getScreenCount();
		for (int sIdx = 0; sIdx < screenCount; sIdx++) {
			Screen s = c.getScreen(sIdx);
			Seat[] avail = s.listAvailable(type); // Screen returns Seat[]
			total += avail.length;
		}

		// 2) Fill
		Seat[] out = new Seat[total];
		int k = 0;
		for (int sIdx = 0; sIdx < screenCount; sIdx++) {
			Screen s = c.getScreen(sIdx);
			Seat[] avail = s.listAvailable(type);
			for (int j = 0; j < avail.length; j++) {
				out[k++] = avail[j];
			}
		}
		return out;
	}

	// -------------------- Displays / Reports --------------------

	/** Compact layouts for every cinema (delegates down to each screen). */
	public void displayLayouts() {
		System.out.println("=== CITY: " + cityName + " | All Cinema Layouts ===");
		for (int i = 0; i < cinemaCount; i++) {
			cinemas[i].displayLayout();
			System.out.println("=======================================");
		}
		System.out.printf("City Totals -> Seats: %d, Available: %d%n",
				getTotalSeatCount(), getAvailableSeatCount());
		System.out.println();
	}

	/** Verbose seat listings for every cinema. */
	public void displayVerbose() {
		System.out.println("=== CITY: " + cityName + " | Detailed Seats ===");
		for (int i = 0; i < cinemaCount; i++) {
			cinemas[i].displayVerbose();
			System.out.println("=======================================");
		}
		System.out.printf("City Totals -> Seats: %d, Available: %d%n",
				getTotalSeatCount(), getAvailableSeatCount());
		System.out.println();
	}

	@Override
	public String toString() {
		return String.format("CityCinema{city='%s', cinemas=%d, totalSeats=%d, available=%d}",
				cityName, cinemaCount, getTotalSeatCount(), getAvailableSeatCount());
	}

	// -------------------- Sample data loader (arrays) --------------------
	/**
	 * Strict array-based preload for labs that require explicit array initialization.
	 * Example: 2 cinemas × 3 screens each, with jagged rows {10,11,12,13,14}.
	 */
	public void loadSampleDataUsingArrays() {
		Cinema[] preset = new Cinema[2];
		for (int i = 0; i < preset.length; i++) {
			preset[i] = new Cinema("Cinema-" + (i + 1), 3); // each cinema preloads 3 screens by default
		}
		cinemas = preset;        // replace backing array
		cinemaCount = preset.length;
	}

	// -------------------- Helpers --------------------

	private Cinema requireCinema(String name) {
		Cinema c = findCinemaByName(name);
		if (c == null) {
			throw new IllegalArgumentException("No cinema named '" + name + "' in city '" + cityName + "'.");
		}
		return c;
	}

	private int indexOfCinema(String cinemaName) {
		if (cinemaName == null) return -1;
		for (int i = 0; i < cinemaCount; i++) {
			Cinema c = cinemas[i];
			if (c != null && cinemaName.equalsIgnoreCase(c.getName())) return i;
		}
		return -1;
	}

	private void ensureCapacity(int minCapacity) {
		int oldCap = (cinemas == null) ? 0 : cinemas.length;
		if (oldCap >= minCapacity) return;
		int newCap = Math.max(1, Math.max(minCapacity, oldCap * 2));
		Cinema[] next = new Cinema[newCap];
		for (int i = 0; i < cinemaCount; i++) next[i] = cinemas[i];
		cinemas = next;
	}
}
