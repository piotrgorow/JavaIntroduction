package pl.coderstrust.figures;

public class Trapezoid implements Figure {
    private double base;
    private double leg;
    private double height;

    public Trapezoid() {
        base = 0.0;
        leg = 0.0;
        height = 0.0;
    }

    public Trapezoid(double base, double leg, double height) {
        if (base < 0.0) {
            throw new IllegalArgumentException("Parameter base cannot be less then zero.");
        }
        if (leg < 0.0) {
            throw new IllegalArgumentException("Parameter leg cannot be less then zero.");
        }
        if (height < 0.0) {
            throw new IllegalArgumentException("Parameter height cannot be less then zero.");
        }
        this.base = base;
        this.leg = leg;
        this.height = height;
    }

    public void setBase(double base) {
        if (base < 0.0) {
            throw new IllegalArgumentException("Parameter base cannot be less then zero.");
        }
        this.base = base;
    }

    public void setLeg(double leg) {
        if (leg < 0.0) {
            throw new IllegalArgumentException("Parameter leg cannot be less then zero.");
        }
        this.leg = leg;
    }

    public void setHeight(double height) {
        if (height < 0.0) {
            throw new IllegalArgumentException("Parameter height cannot be less then zero.");
        }
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return ((base + leg) * height) / 2.0;
    }
}
