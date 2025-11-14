package B;

public class Cylinder extends Shape3D{
    double radius;
    double height;

    public Cylinder(String name, double radius, double height) {
        super(name);
        this.radius = radius;
        this.height = height;
    }

    public double calArea(){
        return Math.PI*Math.pow(radius,2)*height;
    }
    public double calVolume(){
        return Math.PI*Math.pow(radius,2)*height;
    }

}
