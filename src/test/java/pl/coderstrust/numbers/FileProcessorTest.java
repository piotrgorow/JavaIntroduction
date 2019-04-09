package pl.coderstrust.numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FileProcessorTest {

    private FileProcessor fileProcessor = new FileProcessor();
    private List<String> expected = Arrays.asList("0 1 2 3 4 3 2 1 0", "4 3 2 1 0 1 2 3 4", " 1 2 3 4 ", "4 3 2 1");

    @Test
    public void shouldProperReadFromFile() {
        //when
        List<String> result = fileProcessor.readLinesFromFile(".\\src\\main\\resources\\readTest.txt");

        //then
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void shouldProperWriteToFile() {
        //when
        fileProcessor.writeLinesToFile(expected, ".\\src\\main\\resources\\writeTest.txt");
        List<String> result = fileProcessor.readLinesFromFile(".\\src\\main\\resources\\writeTest.txt");

        //then
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}
