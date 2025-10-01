package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cinema {

	private final String name;
	private final List<Screen> screens = new ArrayList<>();

	// --- Constructors ---

	/** Creates a cinema with a given name and N default-config screens. */
	public Cinema(String name, int numScreens) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Cinema name must not be empty.");
		}
		if (numScreens <= 0) {
			throw new IllegalArgumentException("Number of screens must be positive.");
		}
		this.name = name.trim();
		// Preload with default Screen() instances
		for (int i = 1; i <= numScreens; i++) {
			screens.add(new Screen("Screen-" + i, new int[]{10, 11, 12, 13, 14}));
		}
	}

	/** Creates an empty cinema; you can add screens later via addScreen(...). */
	public Cinema(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Cinema name must not be empty.");
		}
		this.name = name.trim();
	}

	// --- Basic getters ---

	public String getName() {
		return name;
	}

	public int getScreenCount() {
		return screens.size();
	}

	public List<Screen> getScreens() {
		return List.copyOf(screens);
	}

	public Screen getScreen(int zeroBasedIndex) {
		checkIndex(zeroBasedIndex);
		return screens.get(zeroBasedIndex);
	}

	public Screen findScreenByName(String screenName) {
		if (screenName == null) return null;
		for (Screen s : screens) {
			if (screenName.equalsIgnoreCase(s.getScreenName())) return s;
		}
		return null;
	}

	// --- Mutators / builders ---

	/** Add an existing screen instance. */
	public void addScreen(Screen screen) {
		Objects.requireNonNull(screen, "screen must not be null");
		// prevent duplicate names
		if (findScreenByName(screen.getScreenName()) != null) {
			throw new IllegalArgumentException("Screen with name '" + screen.getScreenName() + "' already exists.");
		}
		screens.add(screen);
	}

	/** Create and add a screen with a custom name and layout. */
	public Screen addScreen(String screenName, int[] rowLengths) {
		Screen s = new Screen(screenName, rowLengths);
		addScreen(s);
		return s;
	}

	// --- Booking / cancellation (by screen + seat ID) ---

	/** Book by screen index (0-based) and seat ID like "3-007". */
	public boolean book(int screenIndex, String seatId) {
		Screen s = getScreen(screenIndex);
		return s.book(seatId);
	}

	/** Book by screen name and seat ID. */
	public boolean book(String screenName, String seatId) {
		Screen s = requireScreen(screenName);
		return s.book(seatId);
	}

	/** Cancel by screen index and seat ID. */
	public boolean cancel(int screenIndex, String seatId) {
		Screen s = getScreen(screenIndex);
		return s.cancel(seatId);
	}

	/** Cancel by screen name and seat ID. */
	public boolean cancel(String screenName, String seatId) {
		Screen s = requireScreen(screenName);
		return s.cancel(seatId);
	}

	// --- Aggregated metrics across the cinema ---

	public int getTotalSeatCount() {
		int total = 0;
		for (Screen s : screens) total += s.getTotalSeatCount();
		return total;
	}

	public int getAvailableSeatCount() {
		int total = 0;
		for (Screen s : screens) total += s.getAvailableSeatCount();
		return total;
	}

	public int getAvailableSeatCount(Seat.SeatType type) {
		int total = 0;
		for (Screen s : screens) total += s.getAvailableSeatCount(type);
		return total;
	}

	// --- Displays / reports ---

	/** Compact layout for every screen (delegates to Screen.displayLayout()). */
	public void displayLayout() {
		System.out.println("=== CINEMA: " + name + " | Layouts ===");
		for (Screen s : screens) {
			s.displayLayout();
			System.out.println("---------------------------");
		}
		System.out.printf("Cinema Totals -> Seats: %d, Available: %d%n",
				getTotalSeatCount(), getAvailableSeatCount());
		System.out.println();
	}

	/** Verbose seat listing for every screen. */
	public void displayVerbose() {
		System.out.println("=== CINEMA: " + name + " | Detailed Seats ===");
		for (Screen s : screens) {
			s.displayVerbose();
			System.out.println("---------------------------");
		}
		System.out.printf("Cinema Totals -> Seats: %d, Available: %d%n",
				getTotalSeatCount(), getAvailableSeatCount());
		System.out.println();
	}

	/** High-level summary string for logs/UI. */
	@Override
	public String toString() {
		return String.format("Cinema{name='%s', screens=%d, totalSeats=%d, available=%d}",
				name, getScreenCount(), getTotalSeatCount(), getAvailableSeatCount());
	}

	// --- Helpers ---

	private void checkIndex(int idx) {
		if (idx < 0 || idx >= screens.size()) {
			throw new IndexOutOfBoundsException("Screen index out of range: " + idx);
		}
	}

	private Screen requireScreen(String screenName) {
		Screen s = findScreenByName(screenName);
		if (s == null) {
			throw new IllegalArgumentException("No screen named '" + screenName + "' in cinema '" + name + "'.");
		}
		return s;
	}
}
