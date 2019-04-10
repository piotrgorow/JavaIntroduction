package pl.coderstrust.figures;

public class Circle implements Figure {
    private double radius;

    public Circle() {
        radius = 0.0;
    }

    public Circle(double radius) {
        if (radius < 0.0) {
            throw new IllegalArgumentException("Parameter 'radius' cannot be less then zero.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void setRadius(double radius) {
        if (radius < 0.0) {
            throw new IllegalArgumentException("Parameter 'radius' cannot be less then zero.");
        }
        this.radius = radius;
    }
}
