public class Electronics extends Product {
    private final int warrantyMonths;

    public Electronics(int id, String name, double price, String brand, String description, int warrantyMonths) {
        super(id, name, price, brand, description);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() { return warrantyMonths; }

  
    @Override
    public double taxRate() { return 0.15; }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Warranty: " + warrantyMonths + " months";
    }
}
