package org.example;

public class Bus extends PassengerVehicles{
    int numberOfPassengers;

    public Bus(String name, String maker, int seatingCapacity, int numberOfPassengers) {
        super(name, maker, seatingCapacity);
        this.numberOfPassengers = numberOfPassengers;
    }

    void announcement(){
        System.out.println("announcement system of bus");
    }

    @Override
    void trunkCapacity() {

    }

    @Override
    void drive() {

    }

    @Override
    void steer() {

    }

    @Override
    void applyBrakes() {

    }

    @Override
    public void play() {
        System.out.println("Play method of Bus");
    }

    @Override
    public void pause() {

    }

    @Override
    public void next() {

    }
}
