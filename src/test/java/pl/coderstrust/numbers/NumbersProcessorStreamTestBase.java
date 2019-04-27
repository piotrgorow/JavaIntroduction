package pl.coderstrust.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class NumbersProcessorStreamTestBase {

    public abstract FileProcessor getFileProcessor();

    public abstract NumbersProcessorStream getNumberProcessor();

    @ParameterizedTest
    @MethodSource("numberProcessArguments")
    void shouldTestNumbers(String given, List<String> expected) throws IOException {
        //given
        getFileProcessor().writeLinesToFile(Arrays.asList(given), "inputTest.txt");

        //when
        getNumberProcessor().process(".\\target\\classes\\inputTest.txt", ".\\target\\classes\\outputTest.txt");
        List<String> result = getFileProcessor().readLinesFromFile("outputTest.txt");

        //then
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }

    private static Stream<Arguments> numberProcessArguments() {
        return Stream.of(
                Arguments.of("1 2 3  4", Arrays.asList("1 + 2 + 3 + 4 = 10")),
                Arguments.of("  5 6  7 8", Arrays.asList("5 + 6 + 7 + 8 = 26")),
                Arguments.of("  2 _4 __  6_8   ", Arrays.asList()),
                Arguments.of("3  .  5  /  7  * 9", Arrays.asList()),
                Arguments.of("-3 5-7 9", Arrays.asList()),
                Arguments.of("-3-5-7-9", Arrays.asList()),
                Arguments.of("         ", Arrays.asList()),
                Arguments.of("", Arrays.asList())
        );
    }

    @Test
    void shouldThrowExceptionForInvalidInputFileArgument() {
        assertThrows(IllegalArgumentException.class, () -> getNumberProcessor().process(null, "outputFile.txt"));
        assertThrows(IllegalArgumentException.class, () -> getNumberProcessor().process("", "outputFile.txt"));
    }

    @Test
    void shouldThrowExceptionForInvalidOutputFileArgument() {
        assertThrows(IllegalArgumentException.class, () -> getNumberProcessor().process("inputFile.txt", null));
        assertThrows(IllegalArgumentException.class, () -> getNumberProcessor().process("inputFile.txt", ""));
    }
}
