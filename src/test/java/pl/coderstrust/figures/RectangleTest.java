package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    @ParameterizedTest
    @MethodSource("calculateAreaArguments")
    public void shouldCalculateAreaBasedOnConstructor(double sideA, double sideB, double expected) {
        //given
        Rectangle rectangle = new Rectangle(sideA, sideB);

        //when
        double result = rectangle.calculateArea();

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("calculateAreaArguments")
    public void shouldCalculateAreaBasedOnSetters(double sideA, double sideB, double expected) {
        //given
        Rectangle rectangle = new Rectangle();
        rectangle.setSideA(sideA);
        rectangle.setSideB(sideB);

        //when
        double result = rectangle.calculateArea();

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> calculateAreaArguments() {
        return Stream.of(
                Arguments.of(0.0, 5.0, 0.0),
                Arguments.of(1.0, 5.0, 5.0),
                Arguments.of(5.0, 10.0, 50.0),
                Arguments.of(25.0, 50.0, 1250.0)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidSideArguments")
    void shouldThrowExceptionForInvalidSideAPassedToConstructor(double sideA) {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(sideA, 0.0));
    }

    @ParameterizedTest
    @MethodSource("invalidSideArguments")
    void shouldThrowExceptionForInvalidSideBPassedToConstructor(double sideB) {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0.0, sideB));
    }

    @ParameterizedTest
    @MethodSource("invalidSideArguments")
    void shouldThrowExceptionForInvalidSideAPassedToSetter(double sideA) {
        Rectangle rectangle = new Rectangle();
        assertThrows(IllegalArgumentException.class, () -> rectangle.setSideA(sideA));
    }

    @ParameterizedTest
    @MethodSource("invalidSideArguments")
    void shouldThrowExceptionForInvalidSideBPassedToSetter(double sideB) {
        Rectangle rectangle = new Rectangle();
        assertThrows(IllegalArgumentException.class, () -> rectangle.setSideB(sideB));
    }

    private static Stream<Arguments> invalidSideArguments() {
        return Stream.of(
                Arguments.of(-1.0),
                Arguments.of(-10.0),
                Arguments.of(-50.0)
        );
    }
}
