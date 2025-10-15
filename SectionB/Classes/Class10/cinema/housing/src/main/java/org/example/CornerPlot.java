package org.example;

/**
 * A specialized Plot located on a corner (two road frontages).
 * - Adds a premium (%) over the base list price.
 * - You may also record a second frontage width (for reporting).
 */
public class CornerPlot extends Plot {

    public static final double DEFAULT_CORNER_PREMIUM_PERCENT = 8.0;

    private double cornerPremiumPercent;   // e.g., 8.0 means +8%
    private double secondFrontageWidth;    // optional dimension (for reports)

    /**
     * Corner RECTANGLE plot (common case for residential streets 1–2).
     */
    public static CornerPlot rectangle(String id, PlotType type,
                                       double width, double depth,
                                       double secondFrontageWidth) {
        return new CornerPlot(id, type, ShapeType.RECTANGLE,
                width, depth, 0, 0, 0, 0,
                DEFAULT_CORNER_PREMIUM_PERCENT, secondFrontageWidth);
    }

    /**
     * Corner TRAPEZOID plot (e.g., street 3 policy).
     */
    public static CornerPlot trapezoid(String id, PlotType type,
                                       double front, double back, double depth,
                                       double secondFrontageWidth) {
        return new CornerPlot(id, type, ShapeType.TRAPEZOID,
                0, depth, front, back, 0, 0,
                DEFAULT_CORNER_PREMIUM_PERCENT, secondFrontageWidth);
    }

    /**
     * Corner L_SHAPE plot (less common but supported).
     */
    public static CornerPlot lShape(String id, PlotType type,
                                    double w1, double d1, double w2, double d2,
                                    double secondFrontageWidth) {
        return new CornerPlot(id, type, ShapeType.L_SHAPE,
                w1, d1, 0, 0, w2, d2,
                DEFAULT_CORNER_PREMIUM_PERCENT, secondFrontageWidth);
    }

    // General constructor used by factories above.
    public CornerPlot(String id, PlotType type, ShapeType shape,
                      double width, double depth, double front, double back, double w2, double d2,
                      double cornerPremiumPercent, double secondFrontageWidth) {
        super(id, type, shape, width, depth, front, back, w2, d2);
        this.cornerPremiumPercent = (cornerPremiumPercent < 0) ? 0 : cornerPremiumPercent;
        this.secondFrontageWidth = Math.max(0, secondFrontageWidth);
    }

    public double getCornerPremiumPercent() { return cornerPremiumPercent; }
    public void setCornerPremiumPercent(double percent) {
        this.cornerPremiumPercent = Math.max(0, percent);
    }

    public double getSecondFrontageWidth() { return secondFrontageWidth; }
    public void setSecondFrontageWidth(double w) { this.secondFrontageWidth = Math.max(0, w); }

    /** Current price = base listPrice + premium% */
    @Override
    public long currentPrice() {
        double premium = (getListPrice() * cornerPremiumPercent) / 100.0;
        long priced = Math.round(getListPrice() + premium);
        return Math.max(priced, 0L);
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" | corner=%.1f%% secondFrontage=%.1f", cornerPremiumPercent, secondFrontageWidth);
    }
}

