package pl.coderstrust.figures;

public class Rectangle implements Figure {
    private double sideA;
    private double sideB;

    public Rectangle() {
        sideA = 0.0;
        sideB = 0.0;
    }

    public Rectangle(double sideA, double sideB) {
        if (sideA < 0.0) {
            throw new IllegalArgumentException("Parameter sideA cannot be less then zero.");
        }
        if (sideB < 0.0) {
            throw new IllegalArgumentException("Parameter sideB cannot be less then zero.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public void setSideA(double sideA) {
        if (sideA < 0.0) {
            throw new IllegalArgumentException("Parameter sideA cannot be less then zero.");
        }
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        if (sideB < 0.0) {
            throw new IllegalArgumentException("Parameter sideB cannot be less then zero.");
        }
        this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }
}
