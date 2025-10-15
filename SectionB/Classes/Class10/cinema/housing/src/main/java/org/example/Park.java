package org.example;

/**
 * Amenity for a Block. Stores a simple geometric shape and minimal dimensions.
 * Area is computed from shape + dimensions.
 */
public class Park {
    private String name;
    private ShapeType shape;

    // Minimal dimension set (unused fields can stay 0 for a given shape)
    private double width;   // RECTANGLE or L_SHAPE part-1 width
    private double depth;   // RECTANGLE or TRAPEZOID (depth), L_SHAPE part-1 depth
    private double front;   // TRAPEZOID front width
    private double back;    // TRAPEZOID back width
    private double w2;      // L_SHAPE second rectangle width
    private double d2;      // L_SHAPE second rectangle depth

    public Park(String name, ShapeType shape) {
        this.name = name;
        this.shape = shape;
    }

    // --------- Rectangle helpers ----------
    public static Park rectangle(String name, double width, double depth) {
        Park p = new Park(name, ShapeType.RECTANGLE);
        p.width = width;
        p.depth = depth;
        return p;
    }

    // --------- Trapezoid helpers ----------
    public static Park trapezoid(String name, double front, double back, double depth) {
        Park p = new Park(name, ShapeType.TRAPEZOID);
        p.front = front;
        p.back = back;
        p.depth = depth;
        return p;
    }

    // --------- L-Shape helpers ----------
    public static Park lShape(String name, double w1, double d1, double w2, double d2) {
        Park p = new Park(name, ShapeType.L_SHAPE);
        p.width = w1;
        p.depth = d1;
        p.w2 = w2;
        p.d2 = d2;
        return p;
    }

    public String getName() { return name; }
    public ShapeType getShape() { return shape; }

    public double computeArea() {
        switch (shape) {
            case RECTANGLE:
                return width * depth;
            case TRAPEZOID:
                return ((front + back) / 2.0) * depth;
            case L_SHAPE:
                return (width * depth) + (w2 * d2);
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        String dims;
        switch (shape) {
            case RECTANGLE:
                dims = String.format("RECTANGLE %.1f×%.1f", width, depth);
                break;
            case TRAPEZOID:
                dims = String.format("TRAPEZOID front=%.1f back=%.1f depth=%.1f", front, back, depth);
                break;
            case L_SHAPE:
                dims = String.format("L_SHAPE (%.1f×%.1f)+(%.1f×%.1f)", width, depth, w2, d2);
                break;
            default:
                dims = "UNKNOWN";
        }
        return String.format("Park{name='%s', shape=%s, area=%.2f su}", name, dims, computeArea());
    }
}

