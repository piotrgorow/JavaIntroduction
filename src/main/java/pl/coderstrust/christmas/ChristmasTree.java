package pl.coderstrust.christmas;

public class ChristmasTree {

    public static void main(String[] args) {
        printChristmasTree(3);
    }

    public static void printChristmasTree(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (i * 2) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        printChristmasTreeTrunk(size);
    }

    private static void printChristmasTreeTrunk(int heightOfTree) {
        for (int i = 1; i < heightOfTree - 1; i++) {
            System.out.print(" ");
        }
        if (heightOfTree < 4) {
            System.out.println(" *");
        } else {
            System.out.println("***");
        }
    }
}
