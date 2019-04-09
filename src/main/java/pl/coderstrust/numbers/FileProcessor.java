package pl.coderstrust.numbers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public void writeLinesToFile(List<String> resultLines, String resultFileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(resultFileName)) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (String line : resultLines) {
                if (!line.equals("")) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readLinesFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                if (!line.equals("")) {
                    result.add(line);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
