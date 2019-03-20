package pl.coderstrust.foobar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FooBarTest {

    private static Stream<Arguments> createWordsWithLength() {
        return Stream.of(
                Arguments.of("FooBar", 15),
                Arguments.of("FooBar", 0),
                Arguments.of("FooBar", -15));
    }

    @ParameterizedTest
    @MethodSource("createWordsWithLength")
    void shouldReturnCorrectFooBar(String word, int number) {
        String[] fooBar = {"0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar"};
        List<String> expected = new ArrayList<>(Arrays.asList(fooBar));
        int element = number;
        if (element < 0) {
            element = -1;
        }

        //when
        List<String> result = FooBar.getFooBar(number);

        //then
        assertArrayEquals(expected.subList(0, element + 1).toArray(), result.toArray());
    }
}
