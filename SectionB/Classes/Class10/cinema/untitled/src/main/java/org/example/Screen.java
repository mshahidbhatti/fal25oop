package org.example;

public class Screen {

	private static final int DEFAULT_NUM_ROWS = 5;
	private static final double PRICE_REGULAR  = 500.0;
	private static final double PRICE_PREMIUM  = 750.0;
	private static final double PRICE_VIP      = 1000.0;
	private static final double PRICE_RECLINER = 1200.0;

	private final String screenName;

	private final Seat[][] seats; // seats[r][c] is never null after build

	public Screen() {
		this("Screen-1", buildDefaultRowLengths(DEFAULT_NUM_ROWS));
	}

	public Screen(String screenName, int[] rowLengths) {
		if (rowLengths == null || rowLengths.length == 0) {
			throw new IllegalArgumentException("rowLengths must be non-empty.");
		}
		this.screenName = (screenName == null || screenName.trim().isEmpty()) ? "Screen" : screenName.trim();
		this.seats = new Seat[rowLengths.length][];
		for (int r = 0; r < rowLengths.length; r++) {
			int cols = rowLengths[r];
			if (cols <= 0) {
				throw new IllegalArgumentException("Row length must be positive at row index " + r);
			}
			this.seats[r] = new Seat[cols];
			for (int c = 0; c < cols; c++) {
				Seat.SeatType type = seatTypeFor(r, rowLengths.length);
				double price = priceFor(type);
				this.seats[r][c] = new Seat(r + 1, c + 1, type, price);
			}
		}
	}

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

	public Seat getSeat(int zeroBasedRow, int zeroBasedCol) {
		checkBounds(zeroBasedRow, zeroBasedCol);
		return seats[zeroBasedRow][zeroBasedCol];
	}

	public Seat getSeat(String id) {
		if (id == null) return null;
		for (int r = 0; r < seats.length; r++) {
			Seat[] row = seats[r];
			for (int c = 0; c < row.length; c++) {
				Seat s = row[c];
				if (id.equals(s.getId())) return s;
			}
		}
		return null;
	}

	public boolean book(int zeroBasedRow, int zeroBasedCol) {
		Seat s = getSeat(zeroBasedRow, zeroBasedCol);
		return s.bookSeat();
	}

	/** Attempt to book a seat by ID. Returns true on success. */
	public boolean book(String id) {
		Seat s = getSeat(id);
		return s != null && s.bookSeat();
	}

	public boolean cancel(int zeroBasedRow, int zeroBasedCol) {
		Seat s = getSeat(zeroBasedRow, zeroBasedCol);
		return s.cancelBooking();
	}

	public boolean cancel(String id) {
		Seat s = getSeat(id);
		return s != null && s.cancelBooking();
	}


	public int getTotalSeatCount() {
		int total = 0;
		for (int r = 0; r < seats.length; r++) total += seats[r].length;
		return total;
	}

	public int getAvailableSeatCount() {
		int cnt = 0;
		for (int r = 0; r < seats.length; r++) {
			Seat[] row = seats[r];
			for (int c = 0; c < row.length; c++) {
				if (row[c].isAvailable()) cnt++;
			}
		}
		return cnt;
	}

	public int getAvailableSeatCount(Seat.SeatType type) {
		int cnt = 0;
		for (int r = 0; r < seats.length; r++) {
			Seat[] row = seats[r];
			for (int c = 0; c < row.length; c++) {
				Seat s = row[c];
				if (s.getSeatType() == type && s.isAvailable()) cnt++;
			}
		}
		return cnt;
	}

	public Seat findFirstAvailable(Seat.SeatType type) {
		for (int r = 0; r < seats.length; r++) {
			Seat[] row = seats[r];
			for (int c = 0; c < row.length; c++) {
				Seat s = row[c];
				if (s.getSeatType() == type && s.isAvailable()) return s;
			}
		}
		return null;
	}


	public Seat[] listAvailable(Seat.SeatType typeOrNull) {
		int count = 0;
		for (int r = 0; r < seats.length; r++) {
			Seat[] row = seats[r];
			for (int c = 0; c < row.length; c++) {
				Seat s = row[c];
				if (s.isAvailable() && (typeOrNull == null || s.getSeatType() == typeOrNull)) {
					count++;
				}
			}
		}
		Seat[] out = new Seat[count];
		int k = 0;
		for (int r = 0; r < seats.length; r++) {
			Seat[] row = seats[r];
			for (int c = 0; c < row.length; c++) {
				Seat s = row[c];
				if (s.isAvailable() && (typeOrNull == null || s.getSeatType() == typeOrNull)) {
					out[k++] = s;
				}
			}
		}
		return out;
	}

	public void setRowType(int zeroBasedRow, Seat.SeatType type, Double newPriceOrNull) {
		if (type == null) throw new IllegalArgumentException("Seat type must not be null");
		checkRow(zeroBasedRow);
		for (int c = 0; c < seats[zeroBasedRow].length; c++) {
			Seat s = seats[zeroBasedRow][c];
			s.setSeatType(type);
			if (newPriceOrNull != null) s.setPrice(newPriceOrNull.doubleValue());
		}
	}

	public void displayLayout() {
		System.out.println("=== " + screenName + " | Layout ===");
		for (int r = 0; r < seats.length; r++) {
			StringBuilder line = new StringBuilder();
			for (int c = 0; c < seats[r].length; c++) {
				Seat s = seats[r][c];
				char mark = s.isAvailable() ? 'A' : 'X'; // A = Available, X = Booked
				line.append(String.format("[%s:%c] ", s.getId(), mark));
			}
			System.out.println(line.toString());
		}
		System.out.printf("Total: %d, Available: %d%n", getTotalSeatCount(), getAvailableSeatCount());
		System.out.println();
	}

	public void displayVerbose() {
		System.out.println("=== " + screenName + " | Detailed Seats ===");
		for (int r = 0; r < seats.length; r++) {
			Seat[] row = seats[r];
			for (int c = 0; c < row.length; c++) {
				System.out.println(row[c]);
			}
		}
		System.out.println();
	}


	private static int[] buildDefaultRowLengths(int rows) {
		int[] len = new int[rows];
		for (int i = 0; i < rows; i++) len[i] = 10 + i; // 10, 11, 12, ...
		return len;
	}


	private Seat.SeatType seatTypeFor(int zeroBasedRow, int totalRows) {
		if (zeroBasedRow == totalRows - 1) return Seat.SeatType.RECLINER; // ensure last row is recliner

		double idx = zeroBasedRow;
		double n   = totalRows;
		double q   = idx / n;

		if (q < 0.40) return Seat.SeatType.REGULAR;
		if (q < 0.80) return Seat.SeatType.PREMIUM;
		return Seat.SeatType.VIP;
	}

	private double priceFor(Seat.SeatType type) {
		switch (type) {
			case REGULAR:  return PRICE_REGULAR;
			case PREMIUM:  return PRICE_PREMIUM;
			case VIP:      return PRICE_VIP;
			case RECLINER: return PRICE_RECLINER;
			default:       return PRICE_REGULAR;
		}
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
