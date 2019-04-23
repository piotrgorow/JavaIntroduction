package pl.coderstrust.numbers;

class NumbersProcessorStreamTest extends NumbersProcessorStreamTestBase {

    @Override
    public FileProcessor getFileProcessor() {
        return new FileProcessor();
    }

    @Override
    public NumbersProcessorStream getNumberProcessor() {
        return new NumbersProcessorStream();
    }
}
