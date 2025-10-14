public class Inventory {
    private Product[] products = new Product[20];  
    private int[] quantities = new int[20];        
    private int count = 0;                         

    // Add product with quantity
    public void add(Product p, int qty) {
        int index = findProductIndex(p);
        if (index >= 0) {
            quantities[index] += qty;  // product already exists → increase stock
        } else {
            ensureCapacity(count + 1);
            products[count] = p;
            quantities[count] = qty;
            count++;
        }
    }

    // Check if a product has at least qty units
    public boolean has(Product p, int qty) {
        int index = findProductIndex(p);
        return index >= 0 && quantities[index] >= qty;
    }

    // Remove certain quantity from stock
    public void remove(Product p, int qty) {
        int index = findProductIndex(p);
        if (index < 0) {
            throw new IllegalArgumentException("Product not found: " + p.getName());
        }
        if (quantities[index] < qty) {
            throw new IllegalArgumentException("Not enough stock for " + p.getName());
        }
        quantities[index] -= qty;
        if (quantities[index] == 0) {
            removeAt(index);
        }
    }

    // Return how many units exist
    public int getQuantity(Product p) {
        int index = findProductIndex(p);
        if (index >= 0) return quantities[index];
        return 0;
    }

    // Return product list as simple String[]
    public String[] list() {
        String[] lines = new String[count];
        for (int i = 0; i < count; i++) {
            lines[i] = products[i].getDetails() + " | Qty: " + quantities[i];
        }
        return lines;
    }

    // ---------- Helper methods ----------

    private int findProductIndex(Product p) {
        for (int i = 0; i < count; i++) {
            if (products[i] == p) {  // same object reference
                return i;
            }
        }
        return -1;
    }

    private void removeAt(int index) {
        for (int i = index; i < count - 1; i++) {
            products[i] = products[i + 1];
            quantities[i] = quantities[i + 1];
        }
        count--;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= products.length) return;
        int newCap = Math.max(products.length * 2, minCapacity);
        Product[] newProducts = new Product[newCap];
        int[] newQuantities = new int[newCap];
        for (int i = 0; i < count; i++) {
            newProducts[i] = products[i];
            newQuantities[i] = quantities[i];
        }
        products = newProducts;
        quantities = newQuantities;
    }
}
