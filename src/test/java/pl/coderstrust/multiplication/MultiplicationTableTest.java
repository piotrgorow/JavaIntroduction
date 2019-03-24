package pl.coderstrust.multiplication;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MultiplicationTableTest {

    @ParameterizedTest
    @MethodSource("multiplicationTableArguments")
    void shouldReturnCorrectChristmasTree(int number, int[][] expected) {
        //when
        int[][] result = MultiplicationTable.getMultiplicationTable(number);

        //then
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> multiplicationTableArguments() {
        return Stream.of(
                Arguments.of(12, new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24}, {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36}, {4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48}, {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60}, {6, 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 72}, {7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84}, {8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96}, {9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 108}, {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120}, {11, 22, 33, 44, 55, 66, 77, 88, 99, 110, 121, 132}, {12, 24, 36, 48, 60, 72, 84, 96, 108, 120, 132, 144}}),
                Arguments.of(5, new int[][]{{1, 2, 3, 4, 5}, {2, 4, 6, 8, 10}, {3, 6, 9, 12, 15}, {4, 8, 12, 16, 20}, {5, 10, 15, 20, 25}}),
                Arguments.of(4, new int[][]{{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}}),
                Arguments.of(3, new int[][]{{1, 2, 3}, {2, 4, 6}, {3, 6, 9}}),
                Arguments.of(2, new int[][]{{1, 2}, {2, 4}}),
                Arguments.of(1, new int[][]{{1}}));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidArguments(int number) {
        assertThrows(IllegalArgumentException.class, () -> MultiplicationTable.getMultiplicationTable(number));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-1),
                Arguments.of(-3),
                Arguments.of(-10));
    }
}
