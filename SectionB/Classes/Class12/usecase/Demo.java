public class Demo {
    public static void main(String[] args) {
        Store store = new Store("SuperMart Pakistan");

        // Fill store with sample products
        Product[] products = ProductInitializer.createSampleProducts();
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                int qty = (int)(Math.random() * 50) + 10;
                store.getInventory().add(products[i], qty);
            }
        }

        System.out.println("=== Inventory ===");
        String[] lines = store.getInventory().list();
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }

        Cart cart = new Cart();
        cart.add(products[0], 2);  // Dalda Cooking Oil 1L (same object)
        cart.add(products[4], 3);  // Olpers Milk
        cart.add(products[22], 1); // Outfitters T-Shirt

        // Checkout
        String receipt = store.checkout(cart, java.time.LocalDate.now());
        System.out.println("\n=== Sample Checkout ===");
        System.out.println(receipt);
    }
}
