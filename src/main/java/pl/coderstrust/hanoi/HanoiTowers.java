package pl.coderstrust.hanoi;

import java.util.Stack;

public class HanoiTowers {
    private final Stack<Integer>[] towers;
    private final int numberOfDiscs;

    public static void main(String[] args) {
        Stack<Integer>[] towers = new Stack[]{new Stack<Integer>(), new Stack<Integer>(), new Stack<Integer>()};
        int numberOfDiscs = 5;
        for (int i = numberOfDiscs; i > 0; i--) {
            towers[0].push(i);
        }
        HanoiTowers hanoiTowers = new HanoiTowers(towers);
        hanoiTowers.play();
    }

    public HanoiTowers(Stack<Integer>[] towers) {
        if (towers == null) {
            throw new IllegalArgumentException("Parameter towers cannot be null.");
        }
        if (towers.length != 3) {
            throw new IllegalArgumentException("Parameter towers can contain only three towers.");
        }
        if (towers[0].empty()) {
            throw new IllegalArgumentException("Parameter towers cannot be empty.");
        }
        this.towers = towers;
        numberOfDiscs = towers[0].size();
    }

    public Stack<Integer>[] play() {
        printTowers();
        play(numberOfDiscs, towers[0], towers[1], towers[2]);
        return towers;
    }

    private void play(int numberOfDiscs, Stack<Integer> sourceTower, Stack<Integer> tempTower, Stack<Integer> destinationTower) {
        if (numberOfDiscs > 0) {
            play(numberOfDiscs - 1, sourceTower, destinationTower, tempTower);
            destinationTower.push(sourceTower.pop());
            printTowers();
            play(numberOfDiscs - 1, tempTower, sourceTower, destinationTower);
        }
    }

    private void printTowers() {
        StringBuilder hanoiBuilder = new StringBuilder();
        hanoiBuilder.append(" A | B | C").append("\n");
        for (int i = numberOfDiscs - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                String discValue = towers[j].size() > i ? String.valueOf(towers[j].get(i)) : "-";
                hanoiBuilder.append(String.format("%3s ", discValue + " "));
            }
            System.out.println(hanoiBuilder.toString());
            hanoiBuilder.setLength(0);
        }
        System.out.println();
    }
}
