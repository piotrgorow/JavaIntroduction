package pl.coderstrust.multiplication;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MultiplicationTableTest {

    @ParameterizedTest
    @MethodSource("multiplicationTableArguments")
    void shouldReturnCorrectChristmasTree(int number, List<String> expected) {
        //when
        List<String> result = MultiplicationTable.getMultiplicationTable(number);

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> multiplicationTableArguments() {
        return Stream.of(
                Arguments.of(5, Arrays.asList("         1    2    3    4    5", "    1    1    2    3    4    5", "    2    2    4    6    8   10", "    3    3    6    9   12   15", "    4    4    8   12   16   20", "    5    5   10   15   20   25")),
                Arguments.of(4, Arrays.asList("         1    2    3    4", "    1    1    2    3    4", "    2    2    4    6    8", "    3    3    6    9   12", "    4    4    8   12   16")),
                Arguments.of(3, Arrays.asList("         1    2    3", "    1    1    2    3", "    2    2    4    6", "    3    3    6    9")),
                Arguments.of(2, Arrays.asList("         1    2", "    1    1    2", "    2    2    4")));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidArguments(int number) {
        assertThrows(IllegalArgumentException.class, () -> MultiplicationTable.getMultiplicationTable(number));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-3),
                Arguments.of(-10));
    }

}