package org.example;

public class Cyliner extends Shape3D{

    double height;
    double radius;

    public Cyliner(String name, double height, double radius) {
        super(name);
        this.height = height;
        this.radius = radius;
    }

    @Override
    double calArea() {
        return 0;
    }

    @Override
    public double calVolume() {
        return Math.PI*radius*radius*height;
    }
}
