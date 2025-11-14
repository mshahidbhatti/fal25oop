package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Shape shapes[]=new Shape[20];
        shapes[0]=new Circle("Circle",20);
        shapes[1]=new Rectangle("Rectangle",10,20);
        shapes[2]=new Sphere("Sphere",30);
        shapes[3]=new Cyliner("Cylinder",20,20);
        shapes[4]=new Circle("Circle",20);
        shapes[5]=new Rectangle("Rectangle",10,20);
        shapes[6]=new Sphere("Sphere",30);
        shapes[7]=new Cyliner("Cylinder",20,20);

//        for(Shape temp:shapes)
//            System.out.println(temp.getClass().getSimpleName()+" "+temp.calArea());
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        for(Shape temp:shapes)
//            if(temp instanceof Shape3D) {
//                Shape3D temp3D=(Shape3D)temp;
//                System.out.println(temp.getClass().getSimpleName() + " " + temp3D.calVolume());
//            }

        for(int i=0;i<shapes.length;i++)
            if(shapes[i] instanceof Circle)
            {
                Circle t1=(Circle) shapes[i];
                t1.setRadius(t1.getRadius()+5);
            }


    }


    public static void increaseRects(Shape shapes[]){
        if(shapes == null) return;

        for(int i=0; i<shapes.length;i++)
            if(shapes[i] instanceof Rectangle){
                Rectangle r1=(Rectangle) shapes[i];
                r1.setLength(r1.getLength()+5);
                r1.setWidth(r1.getWidth()+5);
            }


    }


    public Rectangle[] getRectangles(Shape shapes[]){
        int counter=0;
        for(int i=0;i<shapes.length;i++)
            if(shapes[i] instanceof Rectangle)
                counter++;
        Rectangle rectangles[]=new Rectangle[counter];
        for(int i=0;i<shapes.length;i++)
        {
           // if(shapes[i] instanceof Rectangle)
            //    rectangles[]=shapes[i];

        }
        return null;
    }
}