package pl.coderstrust.pascal;

public class PascalTriangle {

    public static void main(String[] args) {
        printPascalTriangle(10);
    }

    public static void printPascalTriangle(int number) {
        if (number < 0 || number > 20) {
            System.out.println("Invalid Value! Please enter value between 0 and 20.");
            return;
        }
        for (int i = 0; i < number; i++) {
            for (int j = i + 1; j < number; j++) {
                System.out.printf("%4s", " ");
            }
            for (int j = 0; j <= i; j++) {
                long nodeValue = factorial(i) / (factorial(j) * factorial(i - j));
                System.out.printf("%8d", nodeValue);
            }
            System.out.println();
        }
    }

    private static long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
