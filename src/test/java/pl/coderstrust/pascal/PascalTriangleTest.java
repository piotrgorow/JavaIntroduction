package pl.coderstrust.pascal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PascalTriangleTest {

    @ParameterizedTest
    @MethodSource("pascalTriangleArguments")
    void shouldReturnCorrectPascalTriangle(int number, List<String> expected) {
        //when
        List<String> result = PascalTriangle.getPascalTriangle(number);

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> pascalTriangleArguments() {
        return Stream.of(
                Arguments.of(5, Arrays.asList(
                        "                       1",
                        "                   1       1",
                        "               1       2       1",
                        "           1       3       3       1",
                        "       1       4       6       4       1")),
                Arguments.of(4, Arrays.asList(
                        "                   1",
                        "               1       1",
                        "           1       2       1",
                        "       1       3       3       1")),
                Arguments.of(3, Arrays.asList(
                        "               1",
                        "           1       1",
                        "       1       2       1")),
                Arguments.of(2, Arrays.asList(
                        "           1",
                        "       1       1")));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidArguments(int number) {
        assertThrows(IllegalArgumentException.class, () -> PascalTriangle.getPascalTriangle(number));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(0),
                Arguments.of(-1),
                Arguments.of(-10),
                Arguments.of(21),
                Arguments.of(50));
    }

}
