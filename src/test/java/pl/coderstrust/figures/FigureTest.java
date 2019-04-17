package pl.coderstrust.figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FigureTest {

    @Test
    void shouldReturnFigureArea() {
        Figure figure = new Circle(5);
        double actual = figure.calculateArea();
        assertEquals(78.53981633974483, actual);
        figure = new Rectangle(5, 6);
        actual = figure.calculateArea();
        assertEquals(30.0, actual);
        figure = new Square(5);
        actual = figure.calculateArea();
        assertEquals(25.0, actual);
        figure = new Trapezoid(5, 5, 5);
        actual = figure.calculateArea();
        assertEquals(25.0, actual);
        figure = new Triangle(5, 5);
        actual = figure.calculateArea();
        assertEquals(12.5, actual);
    }
}
