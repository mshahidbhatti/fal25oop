package org.example;

/**
 * Core land unit with geometry, area, pricing, and booking state.
 * - ID format: "street-plot" (e.g., "3-007") validated by PlotIdUtil.
 * - Shape: RECTANGLE / TRAPEZOID / L_SHAPE with minimal dimensions.
 * - Area is computed from shape + dimensions.
 * - Price: taken from PlotType base policy (can be overridden in subclasses).
 * - Availability: available by default; book/cancel mutate state safely.
 *
 * This class is independent of Block/Society (no array fields here).
 */
public class Plot {

    // --------- Identity & categorization ---------
    private final String id;         // "street-plot" e.g., "3-007"
    private final PlotType type;
    private final ShapeType shape;

    // --------- Geometry (minimal dimension set) ---------
    // RECTANGLE: width, depth
    // TRAPEZOID: front, back, depth
    // L_SHAPE  : (width, depth) + (w2, d2)
    protected double width;
    protected double depth;
    protected double front;
    protected double back;
    protected double w2;
    protected double d2;

    // --------- Derived & state ---------
    protected double area;           // computed from shape & dims
    protected long listPrice;        // base list price (not including premiums)
    protected boolean available;     // true=available, false=booked

    // --------- Constructors ---------

    /**
     * General constructor (you can also use the static factories below).
     */
    public Plot(String id, PlotType type, ShapeType shape,
                double width, double depth, double front, double back, double w2, double d2) {
        if (!PlotIdUtil.isValid(id)) {
            throw new IllegalArgumentException("Invalid plot ID: " + id + " (expected street-plot, e.g., 3-007)");
        }
        if (type == null || shape == null) {
            throw new IllegalArgumentException("type and shape must be non-null");
        }
        this.id = id;
        this.type = type;
        this.shape = shape;

        this.width = width;
        this.depth = depth;
        this.front = front;
        this.back = back;
        this.w2 = w2;
        this.d2 = d2;

        this.area = computeAreaInternal();
        this.listPrice = PlotType.priceFor(type);
        this.available = true; // available by default
    }

    // --------- Static factories for convenience ---------

    public static Plot rectangle(String id, PlotType type, double width, double depth) {
        return new Plot(id, type, ShapeType.RECTANGLE, width, depth, 0, 0, 0, 0);
    }

    public static Plot trapezoid(String id, PlotType type, double front, double back, double depth) {
        return new Plot(id, type, ShapeType.TRAPEZOID, 0, depth, front, back, 0, 0);
    }

    public static Plot lShape(String id, PlotType type, double w1, double d1, double w2, double d2) {
        return new Plot(id, type, ShapeType.L_SHAPE, w1, d1, 0, 0, w2, d2);
    }

    // --------- Accessors ---------

    public String getId() { return id; }
    public PlotType getType() { return type; }
    public ShapeType getShape() { return shape; }

    public double getWidth() { return width; }
    public double getDepth() { return depth; }
    public double getFront() { return front; }
    public double getBack() { return back; }
    public double getW2() { return w2; }
    public double getD2() { return d2; }

    /** Recompute area if you change dimensions via subclass logic. */
    protected void recomputeArea() {
        this.area = computeAreaInternal();
    }

    /** Computed area in "square units". */
    public double getArea() { return area; }

    /** Base list price (not including any subclass premiums). */
    public long getListPrice() { return listPrice; }

    /** Current price. Subclasses may override to add premiums (e.g., CornerPlot). */
    public long currentPrice() { return listPrice; }

    /** Availability state. */
    public boolean isAvailable() { return available; }

    // --------- Behaviors ---------

    /** Safe booking: returns true on success, false if already booked. */
    public boolean book() {
        if (!available) return false;
        available = false;
        return true;
    }

    /** Safe cancellation: returns true on success, false if already available. */
    public boolean cancel() {
        if (available) return false;
        available = true;
        return true;
    }

    /** String summary for console output (ID | TYPE | SHAPE | area | price | A/X). */
    @Override
    public String toString() {
        String ax = available ? "A" : "X";
        return String.format("%s | %-12s | %-10s | area=%,.2f su | price=%,d PKR | %s",
                id, type, shape, area, currentPrice(), ax);
    }

    // --------- Internals ---------

    private double computeAreaInternal() {
        switch (shape) {
            case RECTANGLE:
                return maxZero(width) * maxZero(depth);
            case TRAPEZOID:
                return ((maxZero(front) + maxZero(back)) / 2.0) * maxZero(depth);
            case L_SHAPE:
                return (maxZero(width) * maxZero(depth)) + (maxZero(w2) * maxZero(d2));
            default:
                return 0.0;
        }
    }

    private double maxZero(double v) { return v < 0 ? 0 : v; }
}

