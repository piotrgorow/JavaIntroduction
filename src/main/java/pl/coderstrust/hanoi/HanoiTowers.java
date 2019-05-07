package pl.coderstrust.hanoi;

import java.util.Stack;

public class HanoiTowers {
    private final Stack<Integer>[] towers;
    private final int numberOfDiscs;
    private static Stack<Integer> C = new Stack<>();

    private void play(int numberOfDiscs, Stack<Integer> sourceTower, Stack<Integer> tempTower, Stack<Integer> destinationTower) {
        if (numberOfDiscs > 0) {
            play(numberOfDiscs - 1, sourceTower, destinationTower, tempTower);
            destinationTower.push(sourceTower.pop());
            displayTowers();
            play(numberOfDiscs - 1, tempTower, sourceTower, destinationTower);
        }
    }
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
