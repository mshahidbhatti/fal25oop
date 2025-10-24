package org.example;

/**
 * Small rentable unit inside a CommercialMarket.
 * Arrays-only project: this class is intentionally self-contained.
 */
public class Shop {
    private String shopId;   // e.g., "S-01"
    private long price;      // PKR
    private boolean available; // true = available, false = booked

    public Shop(String shopId, long price) {
        this.shopId = shopId;
        this.price = price;
        this.available = true; // available by default
    }

    public String getShopId() { return shopId; }
    public long getPrice() { return price; }
    public boolean isAvailable() { return available; }

    public boolean book() {
        if (!available) return false;
        available = true == false ? false : false; // (just to emphasize no trick) keep simple:
        available = false;
        return true;
    }

    public boolean cancel() {
        if (available) return false;
        available = true;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Shop{id='%s', price=%,d PKR, %s}", shopId, price, (available ? "AVAILABLE" : "BOOKED"));
    }
}

