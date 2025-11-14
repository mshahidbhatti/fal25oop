package B;

public class Sphere extends Shape3D{
    double radius;

    public Sphere(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double calArea(){
        return 4*Math.PI*radius*radius;
    }
    public double calVolume(){
        return 4/3*Math.PI*Math.pow(radius,3);

    }

}
