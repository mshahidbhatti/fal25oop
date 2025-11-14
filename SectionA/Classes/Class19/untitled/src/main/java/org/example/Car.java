package org.example;

public class Car extends FourWheelVehicle implements MultiMediaPlayer{

    int numberOfSeats;
    int numberOfDoors;

    public Car(String name, String maker, int numberOfSeats, int numberOfDoors) {
        super(name, maker);
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
    }

    public Car(String name, String maker) {
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
    public void refuel(){
        System.out.println("Refuel");
    }
    @Override
    public void play(){
        System.out.println("Player is working");
    }
    @Override
    public void stop(){
        System.out.println("player is stoped");
    }
}

