package pl.coderstrust.hanoi;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HanoiTowersTest {

    @Test
    void shouldPlayHanoiTowers() {
        //given
        Stack<Integer>[] towers = new Stack[3];
        towers[0] = new Stack<>();
        towers[0].push(3);
        towers[0].push(2);
        towers[0].push(1);
        towers[1] = new Stack<>();
        towers[2] = new Stack<>();
        Stack<Integer>[] expected = new Stack[3];
        expected[0] = new Stack<>();
        expected[1] = new Stack<>();
        expected[2] = new Stack<>();
        expected[2].push(3);
        expected[2].push(2);
        expected[2].push(1);
        HanoiTowers hanoiTowers = new HanoiTowers(towers);

        //when
        Stack<Integer>[] result = hanoiTowers.play();

        //then
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldThrowExceptionForNullAsTowers() {
        assertThrows(IllegalArgumentException.class, () -> new HanoiTowers(null));
    }

    @Test
    void shouldThrowExceptionForInvalidNumberOfTowers() {
        assertThrows(IllegalArgumentException.class, () -> new HanoiTowers(new Stack[2]));
    }

    @Test
    void shouldThrowExceptionForEmptyFirstTower() {
        Stack<Integer>[] towers = new Stack[3];
        towers[0] = new Stack<>();
        towers[1] = new Stack<>();
        towers[1].push(1);
        towers[2] = new Stack<>();
        towers[2].push(1);
        assertThrows(IllegalArgumentException.class, () -> new HanoiTowers(towers));
    }
}
