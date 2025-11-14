package org.example;

public abstract class TwoWheelVehicles extends Vehicle{
    public TwoWheelVehicles(String name, String maker) {
        super(name, maker);
    }

    public abstract void start();
}
