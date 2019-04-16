package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrapezoidTest {

    @ParameterizedTest
    @MethodSource("calculateAreaArguments")
    public void shouldCalculateAreaBasedOnConstructor(double base, double leg, double height, double expected) {
        //given
        Trapezoid trapezoid = new Trapezoid(base, leg, height);

        //when
        double result = trapezoid.calculateArea();

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("calculateAreaArguments")
    public void shouldCalculateAreaBasedOnSetters(double base, double leg, double height, double expected) {
        //given
        Trapezoid trapezoid = new Trapezoid();
        trapezoid.setBase(base);
        trapezoid.setLeg(leg);
        trapezoid.setHeight(height);

        //when
        double result = trapezoid.calculateArea();

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> calculateAreaArguments() {
        return Stream.of(
                Arguments.of(5.0, 5.0, 5.0, 25.0),
                Arguments.of(0.0, 5.0, 5.0, 12.5),
                Arguments.of(5.0, 0.0, 5.0, 12.5),
                Arguments.of(5.0, 5.0, 0.0, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidBaseLegHeightArguments")
    void shouldThrowExceptionForInvalidBasePassedToConstructor(double base) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(base, 0.0, 0.0));
    }

    @ParameterizedTest
    @MethodSource("invalidBaseLegHeightArguments")
    void shouldThrowExceptionForInvalidLegPassedToConstructor(double leg) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(0.0, leg, 0.0));
    }

    @ParameterizedTest
    @MethodSource("invalidBaseLegHeightArguments")
    void shouldThrowExceptionForInvalidHeightPassedToConstructor(double height) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(0.0, 0.0, height));
    }

    @ParameterizedTest
    @MethodSource("invalidBaseLegHeightArguments")
    void shouldThrowExceptionForInvalidBasePassedToSetter(double base) {
        Trapezoid trapezoid = new Trapezoid();
        assertThrows(IllegalArgumentException.class, () -> trapezoid.setBase(base));
    }

    @ParameterizedTest
    @MethodSource("invalidBaseLegHeightArguments")
    void shouldThrowExceptionForInvalidLegPassedToSetter(double leg) {
        Trapezoid trapezoid = new Trapezoid();
        assertThrows(IllegalArgumentException.class, () -> trapezoid.setLeg(leg));
    }

    @ParameterizedTest
    @MethodSource("invalidBaseLegHeightArguments")
    void shouldThrowExceptionForInvalidHeightPassedToSetter(double height) {
        Trapezoid trapezoid = new Trapezoid();
        assertThrows(IllegalArgumentException.class, () -> trapezoid.setHeight(height));
    }

    private static Stream<Arguments> invalidBaseLegHeightArguments() {
        return Stream.of(
                Arguments.of(-1.0),
                Arguments.of(-10.0),
                Arguments.of(-50.0)
        );
    }
}
