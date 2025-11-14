package B;

public class Circle extends Shape2D{

    double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }


    @Override
    public double calArea(){
        return Math.PI * Math.pow(radius,2);

    }
}
