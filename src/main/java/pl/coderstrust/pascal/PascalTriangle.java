package pl.coderstrust.pascal;

public class PascalTriangle {

    public static void main(String[] args) {
        printPascalTriangle(10);
    }

    public static void printPascalTriangle(int num) {
        if (num > 20 || num < 0) {
            System.out.println("Invalid Value!");
        } else {
            for (int n = 0; n <= num; n++) {
                for (int i = n; i < num; i++) {
                    System.out.printf("%4s", " ");
                }
                for (int k = 0; k <= n; k++) {
                    long result = countFactorial(n) / (countFactorial(k) * countFactorial(n - k));
                    System.out.printf("%8d", result);
                }
                System.out.println();
            }
        }
    }

    private static long countFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
