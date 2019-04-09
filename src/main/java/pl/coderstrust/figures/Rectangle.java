package pl.coderstrust.figures;

public class Rectangle implements Figure {
    private double sideA;
    private double sideB;

    public Rectangle() {
        sideA = 0.0;
        sideB = 0.0;
    }

    public Rectangle(double sideA, double sideB) {
        setSideA(sideA);
        setSideB(sideB);
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }

    public void setSideA(double sideA) {
        if (sideA < 0.0) {
            throwException("a");
        }
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        if (sideB < 0.0) {
            throwException("b");
        }
        this.sideB = sideB;
    }

    private void throwException(String argument) {
        throw new IllegalArgumentException("Parameter '" + argument + "' cannot be less then zero.");
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}
