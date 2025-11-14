package org.example;

public abstract class LoadingVehicle extends Vehicle{
    int loadingCapacity;

    public LoadingVehicle(String name, String maker, int loadingCapacity) {
        super(name, maker);
        this.loadingCapacity = loadingCapacity;
    }


    abstract void load();

}
