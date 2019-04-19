package pl.coderstrust.numbers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class NumbersProcessorStream {

    public void process(String inputFilePath, String outputFilePath) throws IOException {
        if (inputFilePath == null) {
            throw new IllegalArgumentException("");
        }
        if (outputFilePath == null) {
            throw new IllegalArgumentException("");
        }
        File outputFile = new File(outputFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        Files.lines(Paths.get(inputFilePath))
                .filter(line -> line.matches("^[\\d\\s]+"))
                .map(line -> line.trim().split("\\s+"))
                .forEach(arrayOfNumbers -> {
                    long sumOfNumbers = Arrays.stream(arrayOfNumbers)
                            .mapToLong(Long::parseLong)
                            .sum();
                    String numbers = Arrays.stream(arrayOfNumbers)
                            .reduce((number1, number2) -> String.format("%s + %s", number1, number2))
                            .get();
                    try {
                        outputStreamWriter.write(String.format("%s = %d\n", numbers, sumOfNumbers));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        outputStreamWriter.close();
    }
}
