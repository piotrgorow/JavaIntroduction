package pl.coderstrust.pascal;

public class PascalTriangle {

    public static void main(String[] args) {
        printPascalTriangle(10);
    }

    public static void printPascalTriangle(int number) {
        if (num > 20 || num < 0) {
            System.out.println("Invalid Value!");
        } else {
            for (int n = 0; n <= num; n++) {
                for (int i = n; i < num; i++) {
                    System.out.printf("%4s", " ");
                }
                for (int k = 0; k <= n; k++) {
                    long nodeValue = countFactorial(n) / (countFactorial(k) * countFactorial(n - k));
                    System.out.printf("%8d", result);
                }
                System.out.println();
            }
        }
    }

    private static long factorial(int number) {
        long result= 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
