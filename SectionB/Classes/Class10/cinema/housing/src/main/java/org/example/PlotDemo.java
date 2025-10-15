package org.example;

/**
 * Minimal incremental demo for Plot and CornerPlot.
 * Run after adding: PlotType, Plot, CornerPlot, PlotIdUtil, ShapeType.
 */
public class PlotDemo {
    public static void main(String[] args) {
        // IDs via utility to keep format consistent
        String id1 = PlotIdUtil.formatId(1, 1);   // "1-001"
        String id2 = PlotIdUtil.formatId(2, 11);  // "2-011"
        String id3 = PlotIdUtil.formatId(3, 7);   // "3-007"
        String id4 = PlotIdUtil.formatId(3, 8);   // "3-008" (corner)

        // Regular rectangular residential plot (5 marla)
        Plot p1 = Plot.rectangle(id1, PlotType.RES_5_MARLA, 35, 50); // area=1750 su
        // Regular rectangular residential plot (10 marla)
        Plot p2 = Plot.rectangle(id2, PlotType.RES_10_MARLA, 40, 60); // area=2400 su
        // Trapezoid 1-kanal regular (street 3 policy)
        Plot p3 = Plot.trapezoid(id3, PlotType.RES_1_KANAL, 50, 60, 90); // area=((50+60)/2)*90=4950 su
        // Corner 1-kanal (trapezoid) with default +8% premium
        CornerPlot cp = CornerPlot.trapezoid(id4, PlotType.RES_1_KANAL, 52, 62, 90, 30);

        System.out.println("=== Regular Plots ===");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("\n=== Corner Plot (Premium) ===");
        System.out.println(cp);

        // Booking flow on p3
        System.out.println("\n=== Booking Flow (" + p3.getId() + ") ===");
        System.out.println("book #1: " + p3.book());
        System.out.println("book #2 (expect false): " + p3.book());
        System.out.println("cancel: " + p3.cancel());
        System.out.println("state: " + p3);
    }
}

