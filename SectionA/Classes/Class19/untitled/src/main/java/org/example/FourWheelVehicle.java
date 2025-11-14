package org.example;

public abstract class FourWheelVehicle extends Vehicle{


    public FourWheelVehicle(String name, String maker) {
        super(name, maker);
    }

    abstract boolean isFourWheel();
}
