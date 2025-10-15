package org.example;

/**
 * CommercialMarket manages an arrays-only list of Shop units.
 * - Holds a plain Shop[] plus a logical size counter (size).
 * - Supports manual growth (allocate larger array + copy).
 * - Provides search (by ID), booking/cancellation by ID,
 *   counts, and arrays-only filters (two-pass pattern).
 *
 * NOTE: This class depends only on Shop (already provided).
 */
public class CommercialMarket {

    private String name;        // e.g., "Block A Main Market"
    private Shop[] shops;       // physical array storage
    private int size;           // logical number of shops currently stored

    /**
     * Create a market with an initial capacity (array size).
     * @param name market display name
     * @param initialCapacity array capacity; if <= 0, defaults to 12
     */
    public CommercialMarket(String name, int initialCapacity) {
        this.name = (name == null || name.isEmpty()) ? "Market" : name;
        int cap = (initialCapacity <= 0) ? 12 : initialCapacity;
        this.shops = new Shop[cap];
        this.size = 0;
    }

    /**
     * @return market's display name
     */
    public String getName() {
        return name;
    }

    /**
     * Current number of shops (logical size).
     */
    public int totalShops() {
        return size;
    }

    /**
     * Count available (vacant) shops.
     */
    public int availableShops() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (shops[i].isAvailable()) count++;
        }
        return count;
    }

    /**
     * Add a shop (appends at logical end). Grows array if full.
     * @param shop non-null Shop
     * @return true if appended; false if shop is null
     */
    public boolean addShop(Shop shop) {
        if (shop == null) return false;
        ensureCapacity(size + 1);
        shops[size++] = shop;
        return true;
    }

    /**
     * Replace the shop with the same ID (if present) or append if not found.
     * Helps when generating shops by ID and needing idempotency.
     */
    public void upsertShop(Shop shop) {
        if (shop == null) return;
        int idx = indexOfShopId(shop.getShopId());
        if (idx >= 0) {
            shops[idx] = shop;
        } else {
            addShop(shop);
        }
    }

    /**
     * Find a shop by its ID; returns null if not found.
     */
    public Shop findShopById(String shopId) {
        int idx = indexOfShopId(shopId);
        return (idx >= 0) ? shops[idx] : null;
    }

    /**
     * Try to book a shop by ID.
     * @return true if booking succeeded; false otherwise (not found or already booked)
     */
    public boolean bookShop(String shopId) {
        Shop s = findShopById(shopId);
        if (s == null) return false;
        return s.book();
    }

    /**
     * Try to cancel a booking by ID.
     * @return true if cancellation succeeded; false otherwise (not found or already available)
     */
    public boolean cancelShop(String shopId) {
        Shop s = findShopById(shopId);
        if (s == null) return false;
        return s.cancel();
    }

    /**
     * Arrays-only two-pass filter: return FIRST N vacant shops (or fewer if not enough).
     * @param n maximum number to return (<= 0 returns empty array)
     */
    public Shop[] firstVacantShops(int n) {
        if (n <= 0) return new Shop[0];

        // First pass: count up to n
        int count = 0;
        for (int i = 0; i < size && count < n; i++) {
            if (shops[i].isAvailable()) count++;
        }

        // Allocate exactly count
        Shop[] result = new Shop[count];
        int k = 0;
        for (int i = 0; i < size && k < count; i++) {
            if (shops[i].isAvailable()) {
                result[k++] = shops[i];
            }
        }
        return result;
    }

    /**
     * Arrays-only two-pass filter: return ALL vacant shops.
     */
    public Shop[] listAllVacantShops() {
        // First pass: count
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (shops[i].isAvailable()) count++;
        }
        // Allocate
        Shop[] result = new Shop[count];
        // Fill
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (shops[i].isAvailable()) {
                result[k++] = shops[i];
            }
        }
        return result;
    }

    /**
     * Arrays-only two-pass filter: return a COPY of all shops (size length).
     */
    public Shop[] toArray() {
        Shop[] out = new Shop[size];
        for (int i = 0; i < size; i++) out[i] = shops[i];
        return out;
    }

    /**
     * Compact one-line-per-shop layout for console output.
     */
    public String compactLayout() {
        StringBuilder sb = new StringBuilder();
        sb.append("Market: ").append(name)
                .append(" | total=").append(size)
                .append(" | available=").append(availableShops())
                .append('\n');
        for (int i = 0; i < size; i++) {
            Shop s = shops[i];
            sb.append(String.format(" [%s|%s|%,d] ",
                    s.getShopId(),
                    s.isAvailable() ? "A" : "X",
                    s.getPrice()));
            if ((i + 1) % 6 == 0) sb.append('\n'); // wrap lines for readability
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("CommercialMarket{name='%s', shops=%d, available=%d}",
                name, totalShops(), availableShops());
    }

    // ---------- internals ----------

    private int indexOfShopId(String shopId) {
        if (shopId == null) return -1;
        for (int i = 0; i < size; i++) {
            if (shopId.equals(shops[i].getShopId())) return i;
        }
        return -1;
    }

    private void ensureCapacity(int wanted) {
        if (wanted <= shops.length) return;
        int newCap = Math.max(shops.length * 2, wanted);
        Shop[] bigger = new Shop[newCap];
        for (int i = 0; i < size; i++) bigger[i] = shops[i];
        shops = bigger;
    }
}
