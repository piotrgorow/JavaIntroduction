package pl.coderstrust.multiplication;

public class MultiplicationTable {

    public static void main(String[] args) {
        printMultiplicationTable(12);
    }

    public static void printMultiplicationTable(int size) {
        System.out.print("  ");
        for (int i = 1; i <= size; i++) {
            if (i < 10) {
                System.out.print("     " + i);
            } else {
                System.out.print("    " + i);
            }
        }
        System.out.println("\n");
        for (int j = 1; j <= size; j++) {
            if (j < 10) {
                System.out.print(" " + j);
            } else {
                System.out.print(j);
            }
            for (int i = 1; i <= size; i++) {
                if (i * j < 10) {
                    System.out.print("     ");
                } else if (i * j > 9 && i * j < 100) {
                    System.out.print("    ");
                } else {
                    System.out.print("   ");
                }
                System.out.print(i * j);
            }
            System.out.println("\n");
        }
    }
}
