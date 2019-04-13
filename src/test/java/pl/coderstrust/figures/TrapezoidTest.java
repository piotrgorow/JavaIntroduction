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
    public void shouldCalculateArea(double base, double leg, double height, double expected) {
        //given
        Trapezoid trapezoid = new Trapezoid(base, leg, height);

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
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidBaseConstructorArguments(double argument) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(argument, 0.0, 0.0));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidLegConstructorArguments(double argument) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(0.0, argument, 0.0));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidHeightConstructorArguments(double argument) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(0.0, 0.0, argument));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidBaseSetterArguments(double argument) {
        Trapezoid trapezoid = new Trapezoid();
        assertThrows(IllegalArgumentException.class, () -> trapezoid.setBase(argument));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidLegSetterArguments(double argument) {
        Trapezoid trapezoid = new Trapezoid();
        assertThrows(IllegalArgumentException.class, () -> trapezoid.setLeg(argument));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidHeightSetterArguments(double argument) {
        Trapezoid trapezoid = new Trapezoid();
        assertThrows(IllegalArgumentException.class, () -> trapezoid.setHeight(argument));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(-1.0),
                Arguments.of(-10.0),
                Arguments.of(-50.0)
        );
    }
}
