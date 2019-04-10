package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTest {

    @ParameterizedTest
    @MethodSource("parameters")
    public void shouldCalculateAreaOfSquare(double side, double expected) {
        //given
        Square square = new Square(side);

        //when
        double result = square.calculateArea();

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(1.0, 1.0),
                Arguments.of(5.0, 25.0),
                Arguments.of(25.0, 625.0)
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidArguments(double argument) {
        Square square = new Square();
        assertThrows(IllegalArgumentException.class, () -> new Square(argument));
        assertThrows(IllegalArgumentException.class, () -> square.setSide(argument));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(-1.0),
                Arguments.of(-10.0),
                Arguments.of(-50.0)
        );
    }
}
