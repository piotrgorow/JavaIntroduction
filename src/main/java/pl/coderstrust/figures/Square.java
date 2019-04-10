package pl.coderstrust.figures;

public class Square implements Figure {
    private double side;

    public Square() {
        side = 0.0;
    }

    public Square(double side) {
        if (side < 0.0) {
            throw new IllegalArgumentException("Parameter sideA cannot be less than zero");
        }
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    public void setSide(double side) {
        if (side < 0.0) {
            throw new IllegalArgumentException("Parameter sideA cannot be less than zero");
        }
        this.side = side;
    }
}
