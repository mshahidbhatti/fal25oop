package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Vehicle vehicles[]=new Vehicle[20];
        vehicles[0]=new Car("Car","abc",2,2);
        vehicles[1]=new Truck("Car","abc",2000);
        vehicles[2]=new Bus("Bus","Daewoo",2000,20);
        vehicles[3]=new Car("Car","abc",2,2);
        vehicles[4]=new Truck("Car","abc",2000);
        vehicles[5]=new Bus("Bus","Daewoo",2000,20);
        Vehicle car=new Car("Car","abc",2,2);

//        for(Vehicle v:vehicles)
//             if(v instanceof  Truck)
//                ((Truck)v).load();


        for(Vehicle v:vehicles)
            if(v instanceof Vehicle)
                ((MultiMediaPlayer)v).play();

//        MultiMediaPlayer mediaPlayers[]=new MultiMediaPlayer[10];
//        for(int i=0;i<vehicles.length;i++)
//            if(vehicles[i] instanceof MultiMediaPlayer)
//                mediaPlayers[i]=(MultiMediaPlayer)vehicles[i];

    }
}