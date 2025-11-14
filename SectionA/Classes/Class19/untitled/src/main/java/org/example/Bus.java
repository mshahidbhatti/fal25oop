package org.example;

public class Bus extends FourWheelVehicle implements MultiMediaPlayer, LoadingBehaviour{
    public Bus(String name, String maker) {
        super(name, maker);
    }

    @Override
    boolean isFourWheel() {
        return false;
    }

    @Override
    void drive() {

    }

    @Override
    void applyBrakes() {

    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }
}
