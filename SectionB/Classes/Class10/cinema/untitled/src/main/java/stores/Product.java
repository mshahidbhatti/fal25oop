package stores;

public class Product {
    protected final int id;
    protected final String name;
    protected final double price;
    protected final String brand;
    protected final String description;

    public Product(int id, String name, double price, String brand, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public String getDescription() { return description; }

    /** Beginners-friendly hook: by default products are not taxed. Subclasses can override. */
    public double taxRate() { return 0.0; }

    public String getDetails() {
        return name + " (" + brand + ") - $" + String.format("%.2f", price) + " :: " + description;
    }

    @Override
    public String toString() { return getDetails(); }
}
