import java.time.LocalDate;

public class Cart {
    private LineItem[] items = new LineItem[10];
    private int size = 0;

    public void add(Product p, int qty) {
        ensureCapacity(size + 1);
        items[size++] = new LineItem(p, qty);
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= items.length) return;
        int newCap = Math.max(items.length * 2, minCapacity);
        LineItem[] next = new LineItem[newCap];
        for (int i = 0; i < size; i++) next[i] = items[i];
        items = next;
    }

    // Accessors for iterating without collections
    public int size() { return size; }
    public LineItem get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return items[index];
    }

    public double totalBeforeTax() {
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += items[i].subtotal();
        }
        return sum;
    }

    public double totalTax() {
        double t = 0.0;
        for (int i = 0; i < size; i++) {
            t += items[i].tax();
        }
        return t;
    }

    public double grandTotal() {
        return totalBeforeTax() + totalTax();
    }

    public void validateNoExpired(LocalDate today) {
        for (int i = 0; i < size; i++) {
            Product p = items[i].getProduct();
            if (p instanceof Grocery) {
                if (((Grocery) p).isExpired(today)) {
                    throw new IllegalStateException("Cart has expired item: " + p.getName());
                }
            }
        }
    }
}
