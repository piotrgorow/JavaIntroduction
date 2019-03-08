package pl.coderstrust.fibonacci;

public class FibonacciIterative {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            return -1;
        }
        if (fibonacciNumberInOrder < 2) {
            return fibonacciNumberInOrder;
        }
        long previousElement = 0L;
        long currentElement = 1L;
        long tmp;
        for (int i = 2; i <= fibonacciNumberInOrder; i++) {
            tmp = currentElement;
            currentElement += previousElement;
            previousElement = tmp;
        }
        return currentElement;
    }
}
