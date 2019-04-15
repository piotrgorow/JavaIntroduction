package pl.coderstrust.numbers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FileProcessorTest {
    private FileProcessor fileProcessor = new FileProcessor();
    private List<String> expected = Arrays.asList("0 1 2 3 4 3 2 1 0", "4 3 2 1 0 1 2 3 4", " 1 2 3 4 ", "4 3 2 1");

    @Test
    public void shouldProperReadFromFile() {
        //when
        List<String> result = null;
        try {
            result = fileProcessor.readLinesFromFile("readTest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void shouldProperWriteToFile() {
        //when
        try {
            fileProcessor.writeLinesToFile(expected, "writeTest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> result = null;
        try {
            result = fileProcessor.readLinesFromFile("writeTest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @AfterAll
    private static void removeTestFile() {
        FileProcessor fileProcessor = new FileProcessor();
        try {
            fileProcessor.deleteFile("writeTest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
