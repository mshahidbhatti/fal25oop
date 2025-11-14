package org.example;

public abstract class Vehicle {
    String name;
    String maker;

    public Vehicle(String name, String maker) {
        this.name = name;
        this.maker = maker;
    }

    abstract void drive();
    abstract void applyBrakes();

}
