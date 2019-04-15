package pl.coderstrust.numbers;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String fileName = "1000.txt";
        String resultFileName = "result.txt";
        FileProcessor fileProcessor = new FileProcessor();
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process(fileName, resultFileName);
        try {
            fileProcessor.readLinesFromFile(resultFileName).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
