package org.example;

public class Car extends PassengerVehicles{
    int numberOfDoors;

    public Car(String name, String maker, int seatingCapacity, int numberOfDoors) {
        super(name, maker, seatingCapacity);
        this.numberOfDoors = numberOfDoors;
    }


    @Override
    void trunkCapacity() {
        System.out.println(" truck capacity");
    }

    @Override
    void drive() {
        System.out.println("Car drive methods");
    }

    @Override
    void steer() {
        System.out.println("Steer method");
    }

    @Override
    void applyBrakes() {
        System.out.println("brakes ");
    }

    @Override
    public void play() {
        System.out.println("play method of car");

    }

    @Override
    public void pause() {

    }

    @Override
    public void next() {

    }
}
