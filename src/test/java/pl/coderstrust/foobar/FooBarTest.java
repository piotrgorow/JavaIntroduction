package pl.coderstrust.foobar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooBarTest {

    private static Stream<Arguments> fooBarArguments() {
        List<String> result15 = new ArrayList<>(Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar"));
        List<String> result0 = new ArrayList<>(Arrays.asList("0 FooBar"));
        List<String> result_15 = new ArrayList<>();
        return Stream.of(
                Arguments.of(15, Arrays.asList("0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar")),
                Arguments.of(0, Arrays.asList("0 FooBar")),
                Arguments.of(-15, result_15));
    }

    @ParameterizedTest
    @MethodSource("fooBarArguments")
    void shouldReturnCorrectFooBar(int number, List<String> expected) {
        //when
        List<String> result = FooBar.getFooBar(number);

        //then
        assertEquals(expected, result);
    }
}
