package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    @ParameterizedTest
    @MethodSource("calculateAreaArguments")
    void shouldCalculateAreaBasedOnConstructor(double base, double height, double expected) {
        //given
        Triangle triangle = new Triangle(base, height);

        //when
        double result = triangle.calculateArea();

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("calculateAreaArguments")
    void shouldCalculateAreaBasedOnSetters(double base, double height, double expected) {
        //given
        Triangle triangle = new Triangle();
        triangle.setBase(base);
        triangle.setHeight(height);

        //when
        double result = triangle.calculateArea();

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> calculateAreaArguments() {
        return Stream.of(
                Arguments.of(5.0, 5.0, 12.5),
                Arguments.of(0.0, 5.0, 0.0),
                Arguments.of(5.0, 0.0, 0.0),
                Arguments.of(5.0, 10.0, 25.0)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidBaseHeightArguments")
    void shouldThrowExceptionForInvalidBasePassedToConstructor(double base) {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(base, 0.0));
    }

    @ParameterizedTest
    @MethodSource("invalidBaseHeightArguments")
    void shouldThrowExceptionForInvalidHeightPassedToConstructor(double height) {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0.0, height));
    }

    @ParameterizedTest
    @MethodSource("invalidBaseHeightArguments")
    void shouldThrowExceptionForInvalidBasePassedToSetter(double base) {
        Triangle triangle = new Triangle();
        assertThrows(IllegalArgumentException.class, () -> triangle.setBase(base));
    }

    @ParameterizedTest
    @MethodSource("invalidBaseHeightArguments")
    void shouldThrowExceptionForInvalidHeightPassedToSetter(double height) {
        Triangle triangle = new Triangle();
        assertThrows(IllegalArgumentException.class, () -> triangle.setHeight(height));
    }

    private static Stream<Arguments> invalidBaseHeightArguments() {
        return Stream.of(
                Arguments.of(-1.0),
                Arguments.of(-10.0),
                Arguments.of(-50.0)
        );
    }
}
