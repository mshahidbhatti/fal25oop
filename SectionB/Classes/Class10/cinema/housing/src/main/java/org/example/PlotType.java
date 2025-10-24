package org.example;

/**
 * Categories for plots/units with base list prices (PKR).
 * Keep prices here so pricing policy is centralized and easy to verify.
 */
public enum PlotType {
    RES_5_MARLA(4_000_000L),
    RES_10_MARLA(7_500_000L),
    RES_1_KANAL(14_000_000L),
    COMM_SHOP(3_000_000L),
    COMM_OFFICE(5_000_000L),
    PARKING(200_000L);

    private final long basePrice;

    PlotType(long basePrice) { this.basePrice = basePrice; }

    /** Base list price in PKR for this type (before any premiums/adjustments). */
    public long basePrice() { return basePrice; }

    /** Convenience for external callers that only know the enum value. */
    public static long priceFor(PlotType t) {
        return (t == null) ? 0L : t.basePrice();
    }

    /** Optional helpers (not strictly required) */
    public boolean isResidential() {
        return this == RES_5_MARLA || this == RES_10_MARLA || this == RES_1_KANAL;
    }
    public boolean isCommercial() {
        return this == COMM_SHOP || this == COMM_OFFICE;
    }
}

