package pl.coderstrust.numbers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ProcessorTest {

    @Mock
    NumbersProcessor numbersProcessor = mock(NumbersProcessor.class);
    @Mock
    FileProcessor fileProcessor = mock(FileProcessor.class);

    @InjectMocks
    Processor processor = new Processor(numbersProcessor, fileProcessor);

    @Test
    public void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() {
        // given
        when(fileProcessor.readLinesFromFile(".\\src\\main\\resources\\1000.txt")).thenReturn(Arrays.asList("1 2 3"));
        when(numbersProcessor.processLine("1 2 3")).thenReturn("1+2+3=6");

        // when
        processor.process(".\\src\\main\\resources\\1000.txt", ".\\src\\main\\resources\\result.txt");

        // then
        verify(fileProcessor).readLinesFromFile(".\\src\\main\\resources\\1000.txt");
        verify(numbersProcessor).processLine("1 2 3");
        verify(fileProcessor).writeLinesToFile(List.of("1+2+3=6"), ".\\src\\main\\resources\\result.txt");
    }
}
