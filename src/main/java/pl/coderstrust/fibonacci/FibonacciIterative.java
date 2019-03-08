package pl.coderstrust.fibonacci;

public class FibonacciIterative {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static long fibonacci(int fibonacciNumberInOrder) {
        long previousElement = 1L;
        long currentElement = 1L;
        for (int i = 1; i < fibonacciNumberInOrder - 1; i++) {
            long tmp = currentElement;
            currentElement += previousElement;
            previousElement = tmp;
        }
        return currentElement;
    }
}
