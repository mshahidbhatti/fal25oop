package org.example;

public class Sphere extends Shape3D{
    double radius;

    public Sphere(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    double calArea() {
        return 4/3 * Math.PI* Math.pow(radius,3);
    }
    @Override
    public double calVolume() {
        return 4/3 * Math.PI* Math.pow(radius,3);
    }
}
