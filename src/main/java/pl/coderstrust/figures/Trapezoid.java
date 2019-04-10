package pl.coderstrust.figures;

public class Trapezoid implements Figure {
    private double sideA;
    private double sideB;
    private double h;

    public Trapezoid() {
        sideA = 0.0;
        sideB = 0.0;
        h = 0.0;
    }

    public Trapezoid(double base, double leg, double height) {
        setSideA(sideA);
        setSideB(sideB);
        setH(h);
    }

    @Override
    public double calculateArea() {
        return ((sideA + sideB) * h) / 2.0;
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

    public void setH(double h) {
        if (h < 0.0) {
            throwException("h");
        }
        this.h = h;
    }

    private void throwException(String argument) {
        throw new IllegalArgumentException("Parameter '" + argument + "' cannot be less then zero.");
    }

    @Override
    public String toString() {
        return "Trapezoid";
    }
}
