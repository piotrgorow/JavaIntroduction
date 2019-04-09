package pl.coderstrust.numbers;

public class Main {

    public static void main(String[] args) {
        String fileName = ".\\src\\main\\resources\\1000.txt";
        String resultFileName = ".\\src\\main\\resources\\result.txt";
        FileProcessor fileProcessor = new FileProcessor();
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process(fileName, resultFileName);
        fileProcessor.readLinesFromFile(resultFileName).forEach(System.out::println);
    }
}
