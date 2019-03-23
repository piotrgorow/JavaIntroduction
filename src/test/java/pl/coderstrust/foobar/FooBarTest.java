package pl.coderstrust.foobar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FooBarTest {

    @ParameterizedTest
    @MethodSource("fooBarArguments")
    void shouldReturnCorrectFooBar(int number, List<String> expected) {
        //when
        List<String> result = FooBar.getFooBar(number);

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> fooBarArguments() {
        return Stream.of(
                Arguments.of(15, Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar")),
                Arguments.of(0, Arrays.asList("0 FooBar")));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidArguments(int number) {
        assertThrows(IllegalArgumentException.class, () -> FooBar.getFooBar(number));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-3),
                Arguments.of(-100));
    }
}
