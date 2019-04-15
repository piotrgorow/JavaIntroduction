package pl.coderstrust.numbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String fileName, String resultFileName) {
        List<String> linesFromFile = null;
        try {
            linesFromFile = fileProcessor.readLinesFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            resultLines.add(numbersProcessor.processLine(line));
        }
        try {
            fileProcessor.writeLinesToFile(resultLines, resultFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
