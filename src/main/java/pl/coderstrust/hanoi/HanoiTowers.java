package pl.coderstrust.hanoi;

import java.util.Stack;

public class HanoiTowers {
    private final Stack<Integer>[] towers;
    private static Stack<Integer> B = new Stack<>();
    private static Stack<Integer> C = new Stack<>();

    public static void doTowers(int topN, Stack<Integer> from, Stack<Integer> inter, Stack<Integer> to, char labelFrom, char labelInter, char labelTo) {
        if (topN == 1) {
            System.out.println("Moving the disk 1 from " + labelFrom + " to " + labelTo);
            to.push(from.pop());
            printTowers();
        } else {
            doTowers(topN - 1, from, to, inter, labelFrom, labelTo, labelInter);
            System.out.println("Moving the disk " + topN + " from " + labelFrom + " to " + labelTo);
            to.push(from.pop());
            printTowers();
            doTowers(topN - 1, inter, from, to, labelInter, labelFrom, labelTo);
        }
    }

    private static void printTowers() {
        System.out.println("A " + A);
        System.out.println("B " + B);
        System.out.println("C " + C);
    }

    public static void main(String[] args) {
        int nDisks = 3;
        for (int i = nDisks; i > 0; i--) {
            A.push(i);
        }
        printTowers();
        doTowers(nDisks, A, B, C, 'A', 'B', 'C');
    }
}
