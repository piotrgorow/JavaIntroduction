package pl.coderstrust.numbers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProcessorTest {

    @Mock
    private NumbersProcessor numbersProcessor = mock(NumbersProcessor.class);

    @Mock
    private FileProcessor fileProcessor = mock(FileProcessor.class);

    @InjectMocks
    private Processor processor = new Processor(numbersProcessor, fileProcessor);

    @Test
    void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
        // given
        when(fileProcessor.readLinesFromFile("1000.txt")).thenReturn(Arrays.asList("1 2 3"));
        when(numbersProcessor.processLine("1 2 3")).thenReturn("1+2+3=6");

        // when
        processor.process("1000.txt", "result.txt");

        // then
        verify(fileProcessor).readLinesFromFile("1000.txt");
        verify(numbersProcessor).processLine("1 2 3");
        verify(fileProcessor).writeLinesToFile(List.of("1+2+3=6"), "result.txt");
    }
}
