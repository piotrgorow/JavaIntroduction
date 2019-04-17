package pl.coderstrust.figures;

public class Triangle implements Figure {
    private double base;
    private double height;

    public Triangle() {
        base = 0.0;
        height = 0.0;
    }

    public Triangle(double base, double height) {
        if (base < 0.0) {
            throw new IllegalArgumentException("Parameter base cannot be less then zero.");
        }
        if (height < 0.0) {
            throw new IllegalArgumentException("Parameter height cannot be less then zero.");
        }
        this.base = base;
        this.height = height;
    }

    public void setBase(double base) {
        if (base < 0.0) {
            throw new IllegalArgumentException("Parameter base cannot be less then zero.");
        }
        this.base = base;
    }

    public void setHeight(double height) {
        if (height < 0.0) {
            throw new IllegalArgumentException("Parameter height cannot be less then zero.");
        }
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (base * height) / 2.0;
    }
}
