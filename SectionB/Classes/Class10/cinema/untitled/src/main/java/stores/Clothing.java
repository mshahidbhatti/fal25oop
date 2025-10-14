package stores;

public class Clothing extends Product {
    public enum Size { XS, S, M, L, XL, XXL }
    private final Size size;
    private final String material;

    public Clothing(int id, String name, double price, String brand, String description, Size size, String material) {
        super(id, name, price, brand, description);
        this.size = size;
        this.material = material;
    }

    public Size getSize() { return size; }
    public String getMaterial() { return material; }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Size: " + size + " | " + material;
    }
}
