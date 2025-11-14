package org.example;

public class ElectricBike extends TwoWheelVehicles{

    public ElectricBike(String name, String maker) {
        super(name, maker);
    }

    public void charge(){
        System.out.println("Charging");
    }

    @Override
    public void start() {

    }

    @Override
    void drive() {

    }

    @Override
    void applyBrakes() {

    }
}
