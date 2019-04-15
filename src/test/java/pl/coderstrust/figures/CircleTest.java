package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleTest {

    @ParameterizedTest
    @MethodSource("calculateAreaArguments")
    public void shouldCalculateArea(double radius, double expected) {
        //given
        Circle circle = new Circle(radius);

        //when
        double result = circle.calculateArea();

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> calculateAreaArguments() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(1.0, 3.141592653589793),
                Arguments.of(5.0, 78.53981633974483),
                Arguments.of(25.0, 1963.4954084936207)
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidRadiusPassedToConstructor(double radius) {
        assertThrows(IllegalArgumentException.class, () -> new Circle(argument));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidRadiusSetterArguments(double argument) {
        Circle circle = new Circle();
        assertThrows(IllegalArgumentException.class, () -> circle.setRadius(argument));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(-1.0),
                Arguments.of(-10.0),
                Arguments.of(-50.0)
        );
    }
}
