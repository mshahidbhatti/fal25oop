package stores;

import java.time.LocalDate;

public class Grocery extends Product {
    private final LocalDate expiryDate;
    private final double weightKg;

    public Grocery(int id, String name, double price, String brand, String description,
                   LocalDate expiryDate, double weightKg) {
        super(id, name, price, brand, description);
        this.expiryDate = expiryDate;
        this.weightKg = weightKg;
    }

    public LocalDate getExpiryDate() { return expiryDate; }
    public double getWeightKg() { return weightKg; }

    public boolean isExpired(LocalDate today) {
        return expiryDate != null && expiryDate.isBefore(today);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Exp: " + expiryDate + " | " + weightKg + "kg";
    }
}
