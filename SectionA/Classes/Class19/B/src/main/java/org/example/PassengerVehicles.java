package org.example;

import java.io.Serializable;

public abstract class PassengerVehicles extends Vehicle implements MultiMediaPlayer {
    int seatingCapacity;

    public PassengerVehicles(String name, String maker, int seatingCapacity) {
        super(name, maker);
        this.seatingCapacity = seatingCapacity;
    }

    abstract void trunkCapacity();


}
