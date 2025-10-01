package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Screen {

	// --- Configuration defaults (can be overridden in constructors) ---
	private static final int DEFAULT_NUM_ROWS = 5;
	private static final double PRICE_REGULAR  = 500.0;
	private static final double PRICE_PREMIUM  = 750.0;
	private static final double PRICE_VIP      = 1000.0;
	private static final double PRICE_RECLINER = 1200.0;

	// --- Identity / metadata ---
	private final String screenName;

	// --- Seating data structure (jagged 2D) ---
	private final Seat[][] seats; // seats[r][c] is never null after build

	// --- Constructors ---

	/**
	 * Default constructor:
	 * - screenName = "Screen-1"
	 * - 5 rows, with row lengths: 10, 11, 12, 13, 14
	 * - Row-to-type mapping:
	 *      rows 0–1 -> REGULAR
	 *      rows 2–3 -> PREMIUM
	 *      row  4   -> RECLINER
	 * - Price by type as defined in constants above
	 */
	public Screen() {
		this("Screen-1", buildDefaultRowLengths(DEFAULT_NUM_ROWS));
	}

	/**
	 * Construct with a name and a custom jagged layout.
	 * Example rowLengths: {12, 12, 14, 14, 16}
	 */
	public Screen(String screenName, int[] rowLengths) {
		if (rowLengths == null || rowLengths.length == 0) {
			throw new IllegalArgumentException("rowLengths must be non-empty.");
		}
		this.screenName = (screenName == null || screenName.isBlank()) ? "Screen" : screenName.trim();
		this.seats = new Seat[rowLengths.length][];
		// Build seats and assign types/prices
		for (int r = 0; r < rowLengths.length; r++) {
			int cols = rowLengths[r];
			if (cols <= 0) {
				throw new IllegalArgumentException("Row length must be positive at row index " + r);
			}
			this.seats[r] = new Seat[cols];
			for (int c = 0; c < cols; c++) {
				Seat.SeatType type = seatTypeFor(r, c, rowLengths.length);
				double price = priceFor(type);
				// Use 1-based visible row/col in IDs to be human-friendly
				this.seats[r][c] = new Seat(r + 1, c + 1, type, price);
			}
		}
	}

	// --- Public API ---

	public String getScreenName() {
		return screenName;
	}

	public int getRowCount() {
		return seats.length;
	}

	public int getRowLength(int zeroBasedRow) {
		checkRow(zeroBasedRow);
		return seats[zeroBasedRow].length;
	}

	/** Get a seat by zero-based indices. */
	public Seat getSeat(int zeroBasedRow, int zeroBasedCol) {
		checkBounds(zeroBasedRow, zeroBasedCol);
		return seats[zeroBasedRow][zeroBasedCol];
	}

	/** Get a seat by its ID (e.g., "3-007"). Returns null if not found. */
	public Seat getSeat(String id) {
		if (id == null) return null;
		for (Seat[] row : seats) {
			for (Seat s : row) {
				if (id.equals(s.getId())) return s;
			}
		}
		return null;
	}

	/** Attempt to book a seat by zero-based indices. Returns true on success. */
	public boolean book(int zeroBasedRow, int zeroBasedCol) {
		Seat s = getSeat(zeroBasedRow, zeroBasedCol);
		return s.bookSeat();
	}

	/** Attempt to book a seat by ID. Returns true on success. */
	public boolean book(String id) {
		Seat s = getSeat(id);
		return s != null && s.bookSeat();
	}

	/** Attempt to cancel a booking by zero-based indices. Returns true on success. */
	public boolean cancel(int zeroBasedRow, int zeroBasedCol) {
		Seat s = getSeat(zeroBasedRow, zeroBasedCol);
		return s.cancelBooking();
	}

	/** Attempt to cancel a booking by ID. Returns true on success. */
	public boolean cancel(String id) {
		Seat s = getSeat(id);
		return s != null && s.cancelBooking();
	}

	/** Count total seats. */
	public int getTotalSeatCount() {
		int total = 0;
		for (Seat[] row : seats) total += row.length;
		return total;
	}

	/** Count available seats overall. */
	public int getAvailableSeatCount() {
		int cnt = 0;
		for (Seat[] row : seats)
			for (Seat s : row)
				if (s.isAvailable()) cnt++;
		return cnt;
	}

	/** Count available seats by type. */
	public int getAvailableSeatCount(Seat.SeatType type) {
		int cnt = 0;
		for (Seat[] row : seats)
			for (Seat s : row)
				if (s.getSeatType() == type && s.isAvailable()) cnt++;
		return cnt;
	}

	/** Find the first available seat of a given type (or null if none). */
	public Seat findFirstAvailable(Seat.SeatType type) {
		for (Seat[] row : seats)
			for (Seat s : row)
				if (s.getSeatType() == type && s.isAvailable()) return s;
		return null;
	}

	/** List all available seats (optionally filtered by type). */
	public List<Seat> listAvailable(Seat.SeatType typeOrNull) {
		List<Seat> out = new ArrayList<>();
		for (Seat[] row : seats)
			for (Seat s : row)
				if (s.isAvailable() && (typeOrNull == null || s.getSeatType() == typeOrNull))
					out.add(s);
		return out;
	}

	/** Change the type (and optionally price) of all seats in a zero-based row. */
	public void setRowType(int zeroBasedRow, Seat.SeatType type, Double newPriceOrNull) {
		Objects.requireNonNull(type, "Seat type must not be null");
		checkRow(zeroBasedRow);
		for (int c = 0; c < seats[zeroBasedRow].length; c++) {
			Seat s = seats[zeroBasedRow][c];
			s.setSeatType(type);
			if (newPriceOrNull != null) s.setPrice(newPriceOrNull);
		}
	}

	/** Pretty layout for console: shows ID plus availability marker. */
	public void displayLayout() {
		System.out.println("=== " + screenName + " | Layout ===");
		for (int r = 0; r < seats.length; r++) {
			StringBuilder line = new StringBuilder();
			for (int c = 0; c < seats[r].length; c++) {
				Seat s = seats[r][c];
				// Show short cell like [3-007:A] where A = Available, X = Booked
				char mark = s.isAvailable() ? 'A' : 'X';
				line.append(String.format("[%s:%c] ", s.getId(), mark));
			}
			System.out.println(line);
		}
		System.out.printf("Total: %d, Available: %d%n", getTotalSeatCount(), getAvailableSeatCount());
		System.out.println();
	}

	/** Verbose listing of all seats using Seat.toString(). */
	public void displayVerbose() {
		System.out.println("=== " + screenName + " | Detailed Seats ===");
		for (Seat[] row : seats)
			for (Seat s : row)
				System.out.println(s);
		System.out.println();
	}

	// --- Helpers / policies ---

	private static int[] buildDefaultRowLengths(int rows) {
		int[] len = new int[rows];
		for (int i = 0; i < rows; i++) len[i] = 10 + i; // 10, 11, 12, ...
		return len;
	}

	/**
	 * Policy: choose seat type per row (can be changed as desired).
	 * - First 40% rows -> REGULAR
	 * - Next 40% rows  -> PREMIUM
	 * - Last 10% rows  -> VIP
	 * - Last row       -> RECLINER (overrides if needed)
	 */
	private Seat.SeatType seatTypeFor(int zeroBasedRow, int zeroBasedCol, int totalRows) {
		// Ensure last row is recliner
		if (zeroBasedRow == totalRows - 1) return Seat.SeatType.RECLINER;

		double idx = zeroBasedRow;
		double n   = totalRows;
		double q   = idx / n;

		if (q < 0.40) return Seat.SeatType.REGULAR;
		if (q < 0.80) return Seat.SeatType.PREMIUM;
		return Seat.SeatType.VIP;
	}

	private double priceFor(Seat.SeatType type) {
		return switch (type) {
			case REGULAR  -> PRICE_REGULAR;
			case PREMIUM  -> PRICE_PREMIUM;
			case VIP      -> PRICE_VIP;
			case RECLINER -> PRICE_RECLINER;
		};
	}

	private void checkRow(int r) {
		if (r < 0 || r >= seats.length)
			throw new IndexOutOfBoundsException("Row out of bounds: " + r);
	}

	private void checkBounds(int r, int c) {
		checkRow(r);
		if (c < 0 || c >= seats[r].length)
			throw new IndexOutOfBoundsException("Col out of bounds: " + c);
	}
}
