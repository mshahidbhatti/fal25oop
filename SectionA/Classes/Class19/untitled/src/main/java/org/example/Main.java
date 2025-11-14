package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Vehicle vehicle[]=new Vehicle[20];

    vehicle[0] =new Car("Car","maker",2,2);     vehicle[0] =new Car("Car","maker",2,2);
    vehicle[1] =new Car("Car","maker",2,2);
    vehicle[2]=new ElectricBike("Bike","maker");
    vehicle[3]=new Bus("Bike","maker");

    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it
        for(Vehicle v:vehicle)
        {
            if(v instanceof FourWheelVehicle)
                ((MultiMediaPlayer) v).play();
        }
//
//        for(Vehicle v: vehicle)
//        {
//            if(v instanceof ElectricBike)
//            {
//                ElectricBike temp=(ElectricBike) v;
//                temp.charge();
//
//            }
//            if(v instanceof Car)
//                ((Car)v).refuel();
//
//        }
    }
}