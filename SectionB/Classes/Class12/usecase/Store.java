import java.time.LocalDate;

public class Store {
    private final String name;
    private final Inventory inventory;

    public Store(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() { return inventory; }

    public String checkout(Cart cart, LocalDate today) {
        // Validate perishables
        cart.validateNoExpired(today);

        // Check stock
        for (int i = 0; i < cart.size(); i++) {
            LineItem li = cart.get(i);
            if (!inventory.has(li.getProduct(), li.getQuantity())) {
                throw new IllegalStateException("Out of stock: " + li.getProduct().getName());
            }
        }

        // Deduct stock
        for (int i = 0; i < cart.size(); i++) {
            LineItem li = cart.get(i);
            inventory.remove(li.getProduct(), li.getQuantity());
        }

        // Build a simple text receipt
        StringBuilder receipt = new StringBuilder();
        receipt.append("=== ").append(name).append(" Receipt ===\n");
        for (int i = 0; i < cart.size(); i++) {
            receipt.append(cart.get(i)).append("\n");
        }
        receipt.append("---------------------------\n");
        receipt.append(String.format("Subtotal: $%.2f%n", cart.totalBeforeTax()));
        receipt.append(String.format("Tax:      $%.2f%n", cart.totalTax()));
        receipt.append(String.format("TOTAL:    $%.2f%n", cart.grandTotal()));
        receipt.append("Thank you!\n");
        return receipt.toString();
    }
}
