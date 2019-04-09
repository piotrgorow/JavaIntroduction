package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    @ParameterizedTest
    @MethodSource("parameters")
    public void shouldCalculateAreaOfRectangle(double sideA, double sideB, double expected) {
        //given
        Rectangle rectangle = new Rectangle(sideA, sideB);

        //when
        double result = rectangle.calculateArea();

        //then
        assertEquals(expected, result);
        assertEquals("Rectangle", rectangle.toString());
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0.0, 5.0, 0.0),
                Arguments.of(1.0, 5.0, 5.0),
                Arguments.of(5.0, 10.0, 50.0),
                Arguments.of(25.0, 50.0, 1250.0)
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidArguments(double argument) {
        Rectangle rectangle = new Rectangle();
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(argument, 0.0));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0.0, argument));
        assertThrows(IllegalArgumentException.class, () -> rectangle.setSideA(argument));
        assertThrows(IllegalArgumentException.class, () -> rectangle.setSideB(argument));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(-1.0),
                Arguments.of(-10.0),
                Arguments.of(-50.0)
        );
    }
}
