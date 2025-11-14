package B;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.copyOf;

public class main {
    public static void main(String[] args) {

        Shape shapes[]=new Shape[40];
        shapes[0]=new Circle("Circle", 40);
        shapes[1]=new Rectangle("Rectangle",20,30);
        shapes[2]=new Sphere("Sphere",50);
        shapes[3]=new Cylinder("Cylinder",50,40);
        shapes[4]=new Circle("Circle", 40);
        shapes[5]=new Rectangle("Rectangle",20,30);
        shapes[6]=new Sphere("Sphere",50);
        shapes[7]=new Cylinder("Cylinder",50,40);

        Shape shape2[];

//        for(Shape temp:shapes)
//            System.out.println(temp.calArea());

//        for(Shape temp:shapes)
//            if(temp instanceof Shape3D) {
//                Shape3D shape3D=(Shape3D)temp ;
//                System.out.println(shape3D.calVolume());
//            }

        for(int i=0;i<shapes.length;i++)
            if(shapes[i] instanceof Shape3D)
            {
                Shape3D shape3D=(Shape3D) shapes[i];
                System.out.println(shape3D.getClass().getCanonicalName()+" "+shape3D.calVolume());
            }

    }

    public static void increaseRectSize(Shape shape[]){
        for (Shape temp: shape)
            if(temp instanceof  Rectangle)
            {
                Rectangle r=(Rectangle) temp;
                r.setHeight(r.getHeight()+1);
                r.setWidth(r.getWidth()+1);
            }

    }

}
