package pl.coderstrust.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumbersProcessorTest {
    private NumbersProcessor numbersProcessor = new NumbersProcessor();

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldTestNumbers(String given, String expected) {
        //when
        String result = numbersProcessor.processLine(given);

        //then
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1_2+3_4", "1+2+3+4=10"),
                Arguments.of("  5 6  7 8", "5+6+7+8=26"),
                Arguments.of("  2 _4 __  6_8   ", "2+4+6+8=20"),
                Arguments.of("3  .  5  /  7  * 9", "3+5+7+9=24"),
                Arguments.of("-3 5-7 9", "-3+5-7+9=4"),
                Arguments.of("-3-5-7-9", "-3-5-7-9=-24"),
                Arguments.of("         ", ""),
                Arguments.of("", "")
        );
    }
}
