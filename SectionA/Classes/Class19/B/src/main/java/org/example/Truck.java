package org.example;

public class Truck extends LoadingVehicle{
    int capacity;
    public Truck(String name, String maker, int loadingCapacity) {
        super(name, maker, loadingCapacity);
    }

    @Override
    void load() {
        System.out.println("Loading ");
    }


    @Override
    void drive() {
        System.out.println("Drive method of truck");
    }

    @Override
    void steer() {
        System.out.println("steer method of truck");
    }

    @Override
    void applyBrakes() {
        System.out.println("brakes of truck");
    }
}
