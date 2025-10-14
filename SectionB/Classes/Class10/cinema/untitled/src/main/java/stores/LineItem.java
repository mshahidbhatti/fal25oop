package stores;

public class LineItem {
    private final Product product;
    private final int quantity;

    public LineItem(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be > 0");
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double subtotal() { return product.getPrice() * quantity; }
    public double tax() { return product.taxRate() * subtotal(); }

    @Override
    public String toString() {
        return quantity + " x " + product.getName() + " @ $" + String.format("%.2f", product.getPrice())
               + " = $" + String.format("%.2f", subtotal());
    }
}
