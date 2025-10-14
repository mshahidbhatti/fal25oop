package stores;

import java.time.LocalDate;

public class ProductInitializer {

    public static Product[] createSampleProducts() {
        Product[] items = new Product[50];
        int i = 0;

        // --- Grocery items (fresh food & daily use) ---
        items[i++] = new Grocery(101, "Dalda Cooking Oil 1L", 620, "Dalda", "Refined vegetable oil", LocalDate.now().plusDays(60), 1);
        items[i++] = new Grocery(102, "Shan Biryani Masala", 120, "Shan Foods", "Masala mix for biryani", LocalDate.now().plusYears(1), 0.05);
        items[i++] = new Grocery(103, "Tapal Danedar Tea 500g", 890, "Tapal", "Strong blend of black tea", LocalDate.now().plusYears(2), 0.5);
        items[i++] = new Grocery(104, "National Ketchup 1kg", 450, "National", "Tomato ketchup bottle", LocalDate.now().plusMonths(10), 1);
        items[i++] = new Grocery(105, "Olpers Milk 1L", 280, "Olpers", "Tetra pack milk", LocalDate.now().plusDays(25), 1);
        items[i++] = new Grocery(106, "Nurpur Butter 200g", 430, "Nurpur", "Pure dairy butter", LocalDate.now().plusDays(15), 0.2);
        items[i++] = new Grocery(107, "Bake Parlour Macaroni 400g", 190, "Bake Parlour", "Elbow macaroni pasta", LocalDate.now().plusYears(1), 0.4);
        items[i++] = new Grocery(108, "Mitchell’s Jam Strawberry 450g", 340, "Mitchell’s", "Strawberry fruit jam", LocalDate.now().plusMonths(6), 0.45);
        items[i++] = new Grocery(109, "Nestle Everyday 400g", 660, "Nestle", "Tea whitener powder", LocalDate.now().plusMonths(8), 0.4);
        items[i++] = new Grocery(110, "K&N Nuggets 1kg", 1150, "K&N", "Frozen chicken nuggets", LocalDate.now().plusDays(45), 1);

        // --- Electronics (common in Pakistan markets) ---
        items[i++] = new Electronics(201, "Haier Refrigerator 10 cuft", 69000, "Haier", "Double door fridge", 24);
        items[i++] = new Electronics(202, "Orient LED TV 43 inch", 72000, "Orient", "Smart LED TV 1080p", 24);
        items[i++] = new Electronics(203, "Dawlance Microwave Oven 25L", 18500, "Dawlance", "Digital microwave oven", 12);
        items[i++] = new Electronics(204, "Kenwood Split AC 1.5 Ton", 162000, "Kenwood", "Inverter air conditioner", 36);
        items[i++] = new Electronics(205, "QMobile Power Bank 10000mAh", 2800, "QMobile", "Portable charger", 6);
        items[i++] = new Electronics(206, "Infinix Hot 12 Smartphone", 39000, "Infinix", "128GB storage, 6GB RAM", 12);
        items[i++] = new Electronics(207, "Audionic Speakers Mehfil MH-20", 9600, "Audionic", "Bluetooth speakers", 12);
        items[i++] = new Electronics(208, "Philips Iron", 4500, "Philips", "Steam iron", 18);
        items[i++] = new Electronics(209, "Sencor Electric Kettle 1.7L", 4200, "Sencor", "Electric water kettle", 12);
        items[i++] = new Electronics(210, "Canon Printer G3010", 57000, "Canon", "Ink tank printer", 24);

        // --- Clothing (local brands & types) ---
        items[i++] = new Clothing(301, "Khaadi Kurta", 3600, "Khaadi", "Cotton embroidered kurta", Clothing.Size.M, "Cotton");
        items[i++] = new Clothing(302, "Junaid Jamshed Shalwar Kameez", 5800, "J.", "Formal cotton suit", Clothing.Size.L, "Cotton");
        items[i++] = new Clothing(303, "Outfitters T-Shirt", 1990, "Outfitters", "Casual t-shirt for men", Clothing.Size.L, "Jersey");
        items[i++] = new Clothing(304, "Edenrobe Jeans", 4200, "Edenrobe", "Slim fit denim jeans", Clothing.Size.M, "Denim");
        items[i++] = new Clothing(305, "Bonanza Sweater", 5200, "Bonanza", "Winter wool sweater", Clothing.Size.L, "Wool");
        items[i++] = new Clothing(306, "Gul Ahmed Dupatta", 1850, "Gul Ahmed", "Printed cotton dupatta", Clothing.Size.M, "Cotton");
        items[i++] = new Clothing(307, "Leisure Club Hoodie", 3800, "Leisure Club", "Warm fleece hoodie", Clothing.Size.L, "Fleece");
        items[i++] = new Clothing(308, "Alkaram Kurti", 2950, "Alkaram", "Printed women kurti", Clothing.Size.S, "Lawn");
        items[i++] = new Clothing(309, "Sapphire Shirt", 3300, "Sapphire", "Formal shirt for men", Clothing.Size.L, "Cotton");
        items[i++] = new Clothing(310, "Nishat Linen Scarf", 1750, "Nishat Linen", "Soft printed scarf", Clothing.Size.M, "Linen");

        // --- Household & general items ---
        items[i++] = new Product(401, "Diamond Detergent Powder 1kg", 290, "Diamond", "Washing powder pack");
        items[i++] = new Product(402, "Safeguard Soap 150g", 130, "Safeguard", "Anti-bacterial soap bar");
        items[i++] = new Product(403, "Lifebuoy Hand Wash 200ml", 260, "Lifebuoy", "Liquid handwash bottle");
        items[i++] = new Product(404, "Lux Perfumed Soap 120g", 110, "Lux", "Floral fragrance soap");
        items[i++] = new Product(405, "Colgate Toothpaste 150g", 240, "Colgate", "Fluoride toothpaste");
        items[i++] = new Product(406, "Dettol Antiseptic 500ml", 430, "Dettol", "Antiseptic liquid");
        items[i++] = new Product(407, "Rose Petal Tissue Box", 220, "Rose Petal", "Facial tissues 200 sheets");
        items[i++] = new Product(408, "Servis School Shoes", 2500, "Servis", "Black school shoes for boys");
        items[i++] = new Product(409, "Panadol Tablet Pack", 70, "GSK", "Pain relief tablets 10 pcs");
        items[i++] = new Product(410, "Always Sanitary Pads 8pcs", 390, "Always", "Cotton comfort pack");

        // --- Add more to reach around 50 items ---
        items[i++] = new Grocery(411, "Rice Basmati 5kg", 2250, "Guard", "Premium basmati rice", LocalDate.now().plusMonths(8), 5);
        items[i++] = new Grocery(412, "Sugar 1kg", 190, "Utility Store", "White refined sugar", LocalDate.now().plusMonths(10), 1);
        items[i++] = new Grocery(413, "Salt 800g", 85, "National", "Iodized salt", LocalDate.now().plusYears(1), 0.8);
        items[i++] = new Grocery(414, "Flour (Atta) 10kg", 1250, "Punjab Atta", "Wheat flour bag", LocalDate.now().plusMonths(2), 10);
        items[i++] = new Grocery(415, "Pepsi 1.5L", 220, "Pepsi", "Soft drink bottle", LocalDate.now().plusMonths(4), 1.5);
        items[i++] = new Grocery(416, "Nestle Water 1.5L", 140, "Nestle", "Mineral water", LocalDate.now().plusMonths(12), 1.5);
        items[i++] = new Grocery(417, "Eggs (Dozen)", 340, "Farm Fresh", "12 medium eggs", LocalDate.now().plusDays(10), 0.7);
        items[i++] = new Grocery(418, "Bread (Medium)", 180, "Dawn", "Fresh white bread loaf", LocalDate.now().plusDays(3), 0.4);
        items[i++] = new Grocery(419, "Yogurt 500g", 190, "Nurpur", "Plain dairy yogurt", LocalDate.now().plusDays(7), 0.5);
        items[i++] = new Grocery(420, "Coke 1.5L", 220, "Coca Cola", "Soft drink bottle", LocalDate.now().plusMonths(4), 1.5);

        return items;
    }

    // Adds all products into the store's inventory with random initial stock quantities
    public static void fillInventoryWithSampleData(Store store) {
        Product[] products = createSampleProducts();
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                int qty = (int)(Math.random() * 50) + 10; // random stock between 10 and 60
                store.getInventory().add(products[i], qty);
            }
        }
    }
}
