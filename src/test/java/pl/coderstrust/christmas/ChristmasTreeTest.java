package pl.coderstrust.christmas;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChristmasTreeTest {

    @ParameterizedTest
    @MethodSource("christmasTreeArguments")
    void shouldReturnCorrectChristmasTree(int number, List<String> expected) {
        //when
        List<String> result = ChristmasTree.getChristmasTree(number);

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> christmasTreeArguments() {
        return Stream.of(
                Arguments.of(10, Arrays.asList("         *", "        ***", "       *****", "      *******", "     *********", "    ***********", "   *************", "  ***************", " *****************", "*******************", "        ***")),
                Arguments.of(5, Arrays.asList("    *", "   ***", "  *****", " *******", "*********", "   ***")),
                Arguments.of(3, Arrays.asList("  *", " ***", "*****", "  *")),
                Arguments.of(2, Arrays.asList(" *", "***", " *")));
    }

    @ParameterizedTest
    @MethodSource("exceptionsArguments")
    void shouldThrowExceptionForInvalidArguments(int number) {
        assertThrows(IllegalArgumentException.class, () -> ChristmasTree.getChristmasTree(number));
    }

    private static Stream<Arguments> exceptionsArguments() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(0),
                Arguments.of(-1),
                Arguments.of(-3),
                Arguments.of(-10));
    }
}
