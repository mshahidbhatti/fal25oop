package org.example;

/**
 * Run this first to test independent classes (Park, Shop).
 * Next batch will add CommercialMarket, then Plot/CornerPlot, then Block/Society/City.
 */
public class BasicAmenitiesDemo {
    public static void main(String[] args) {
        // --- Parks ---
        Park p1 = Park.rectangle("Block A Central Park", 60, 40);
        Park p2 = Park.trapezoid("Block B Green Belt", 30, 50, 20);
        Park p3 = Park.lShape("Block C Corner Green", 20, 15, 10, 8);

        System.out.println("Parks:");
        System.out.println(" - " + p1);
        System.out.println(" - " + p2);
        System.out.println(" - " + p3);

        // --- Shops ---
        Shop s1 = new Shop("S-01", 2_500_000);
        Shop s2 = new Shop("S-02", 2_750_000);

        System.out.println("\nShops (initial):");
        System.out.println(" - " + s1);
        System.out.println(" - " + s2);

        // Book S-01, try double-book, then cancel
        System.out.println("\nBooking flow for S-01:");
        System.out.println(" book #1: " + s1.book());
        System.out.println(" book #2 (should fail): " + s1.book());
        System.out.println(" cancel: " + s1.cancel());
        System.out.println(" state: " + s1);
    }
}
