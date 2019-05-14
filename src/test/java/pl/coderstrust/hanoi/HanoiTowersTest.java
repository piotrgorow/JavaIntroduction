package pl.coderstrust.hanoi;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HanoiTowersTest {

    @Test
    void shouldReturnCorrectArrayOfTowersWhenPassedFourElements() {
        //given
        Stack<Integer>[] towers = new Stack[3];
        towers[0] = new Stack<>();
        towers[0].push(3);
        towers[0].push(2);
        towers[0].push(1);
        towers[1] = new Stack<>();
        towers[2] = new Stack<>();
        towers[0].push(4);
        towers[0].push(3);
        towers[0].push(2);
        towers[0].push(1);
        HanoiTowers hanoiTowers = new HanoiTowers(towers);
        Stack<Integer>[] expected = new Stack[]{new Stack<Integer>(), new Stack<Integer>(), new Stack<Integer>()};
        expected[2].push(4);
        expected[2].push(3);
        expected[2].push(2);
        expected[2].push(1);

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
        assertThrows(IllegalArgumentException.class, () -> new HanoiTowers(new Stack[]{new Stack<Integer>(), new Stack<Integer>()}));
    }

    @Test
    void shouldThrowExceptionForEmptyFirstTower() {
        Stack<Integer>[] towers = new Stack[3];
        towers[0] = new Stack<>();
        towers[1] = new Stack<>();
        towers[1].push(1);
        towers[2] = new Stack<>();
        towers[2].push(1);
        assertThrows(IllegalArgumentException.class, () -> new HanoiTowers(new Stack[]{new Stack<Integer>(), new Stack<Integer>(), new Stack<Integer>()}));
    }
}
