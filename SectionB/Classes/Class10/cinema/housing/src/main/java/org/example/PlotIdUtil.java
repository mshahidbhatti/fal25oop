package org.example;

/**
 * Utility for working with plot IDs in the format "street-plot",
 * e.g., "3-007" where street is 1-based and plot is a 3-digit number.
 *
 * This is deliberately independent of Plot/Block so you can reuse it
 * across demos and unit tests before those classes exist.
 */
public final class PlotIdUtil {

    private PlotIdUtil() {} // no instances

    /**
     * Create a plot ID given a 1-based street index and a plot number.
     * The plot number is zero-padded to 3 digits (e.g., 7 -> "007").
     */
    public static String formatId(int streetIndexOneBased, int plotNumber) {
        if (streetIndexOneBased <= 0) {
            throw new IllegalArgumentException("street index must be >= 1");
        }
        if (plotNumber < 0) {
            throw new IllegalArgumentException("plot number must be >= 0");
        }
        return streetIndexOneBased + "-" + String.format("%03d", plotNumber);
    }

    /**
     * Validate if a string matches the expected "street-plot" pattern.
     * Examples of valid: "1-000", "3-007", "5-123".
     */
    public static boolean isValid(String id) {
        if (id == null) return false;
        // Quick check: digits + dash + exactly 3 digits; street must be >= 1
        // Regex: ^([1-9][0-9]*)-(\\d{3})$
        int dash = id.indexOf('-');
        if (dash <= 0 || dash == id.length() - 1) return false;

        String streetPart = id.substring(0, dash);
        String plotPart = id.substring(dash + 1);

        // street must be positive integer (no leading + or sign)
        if (!isAllDigits(streetPart)) return false;
        if (streetPart.startsWith("0")) return false; // no leading zero for street
        // plot must be exactly 3 digits
        if (plotPart.length() != 3 || !isAllDigits(plotPart)) return false;
        return Integer.parseInt(streetPart) >= 1;
    }

    /**
     * Extract 1-based street index from an ID. Throws if invalid.
     */
    public static int streetIndex(String id) {
        checkValid(id);
        int dash = id.indexOf('-');
        return Integer.parseInt(id.substring(0, dash));
    }

    /**
     * Extract 0-based plot index (the numeric part) from an ID. Throws if invalid.
     * Note: we return the integer value of the 3-digit part; this is NOT zero-based
     * for array indexing unless you design it that way in your Block code.
     */
    public static int plotNumber(String id) {
        checkValid(id);
        int dash = id.indexOf('-');
        return Integer.parseInt(id.substring(dash + 1)); // e.g., "007" -> 7
    }

    /**
     * Useful when walking a street's plots: generate the next plot ID.
     * If plotNumber exceeds 999, we still format with 3 digits modulo 1000 —
     * normally your Block logic should cap lengths per street.
     */
    public static String nextId(String id) {
        checkValid(id);
        int s = streetIndex(id);
        int p = plotNumber(id);
        return formatId(s, p + 1);
    }

    /**
     * Compare two plot IDs in street-then-plot order.
     * Returns negative, zero, or positive like Comparator.
     * Assumes both IDs are valid.
     */
    public static int compare(String idA, String idB) {
        int sA = streetIndex(idA), sB = streetIndex(idB);
        if (sA != sB) return Integer.compare(sA, sB);
        int pA = plotNumber(idA), pB = plotNumber(idB);
        return Integer.compare(pA, pB);
    }

    // ------------- internals -------------

    private static void checkValid(String id) {
        if (!isValid(id)) {
            throw new IllegalArgumentException("Invalid plot ID: " + id + " (expected street-plot, e.g., 3-007)");
        }
    }

    private static boolean isAllDigits(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }
}
