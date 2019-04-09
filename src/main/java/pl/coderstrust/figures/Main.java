package pl.coderstrust.figures;

public class Main {

    public static void main(String[] args) {
        Square square = new Square(2.0);
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        Circle circle = new Circle(3);
        Trapezoid trapezoid = new Trapezoid(2.0, 3.0, 4.0);
        Figure[] figures = new Figure[4];
        figures[0] = square;
        figures[1] = rectangle;
        figures[2] = circle;
        figures[3] = trapezoid;
        for (Figure element : figures) {
            System.out.println("Area of " + element + " is equal: " + element.calculateArea());
        }
    }
}
