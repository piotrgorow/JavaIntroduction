package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FigureTest {

    @ParameterizedTest
    @MethodSource("figureTestArguments")
    public void shouldReturnFigureArea() {
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
        //when
        double result = figure.calculateArea();

        //then
        assertEquals(expected, result);
    }

    private static Object[] figureTestArguments() {
        return new Object[]{
                new Object[]{new Circle(0.0), 0.0},
                new Object[]{new Circle(5.0), 78.53981633974483},
                new Object[]{new Circle(25.0), 1963.4954084936207},
                new Object[]{new Rectangle(0.0, 0.0), 0.0},
                new Object[]{new Rectangle(5.0, 10.0), 50.0},
                new Object[]{new Rectangle(25.0, 50.0), 1250.0},
                new Object[]{new Square(0.0), 0.0},
                new Object[]{new Square(5.0), 25.0},
                new Object[]{new Square(25.0), 625.0},
                new Object[]{new Trapezoid(0.0, 0.0, 0.0), 0.0},
                new Object[]{new Trapezoid(5.0, 0.0, 5.0), 12.5},
                new Object[]{new Trapezoid(5.0, 5.0, 5.0), 25.0},
                new Object[]{new Triangle(0.0, 0.0), 0.0},
                new Object[]{new Triangle(5.0, 5.0), 12.5},
                new Object[]{new Triangle(5.0, 10.0), 25.0},
        };
    }
}
