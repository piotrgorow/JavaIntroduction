package pl.coderstrust.figures;

public class Square extends Rectangle implements Figure {

    public Square() {
        super(0.0, 0.0);
    }

    public Square(double sideA) {
        super(sideA, sideA);
    }

    @Override
    public void setSideA(double sideA) {
        super.setSideA(sideA);
        super.setSideB(sideA);
    }

    @Override
    public String toString() {
        return "Square";
    }
}
