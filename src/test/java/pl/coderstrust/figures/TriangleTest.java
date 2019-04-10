package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    @ParameterizedTest
    @MethodSource("parameters")
    public void shouldCalculateAreaOfTriangle(double base, double height, double expected) {
        //given
        Triangle triangle = new Triangle(base, height);

        //when
        double result = triangle.calculateArea();

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(5.0, 5.0, 12.5),
                Arguments.of(0.0, 5.0, 0.0),
                Arguments.of(5.0, 0.0, 0.0),
                Arguments.of(5.0, 10.0, 25.0)
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidArguments(double argument) {
        Triangle triangle = new Triangle();
        assertThrows(IllegalArgumentException.class, () -> new Triangle(argument, 0.0));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0.0, argument));
        assertThrows(IllegalArgumentException.class, () -> triangle.setBase(argument));
        assertThrows(IllegalArgumentException.class, () -> triangle.setHeight(argument));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(-1.0),
                Arguments.of(-10.0),
                Arguments.of(-50.0)
        );
    }
}
