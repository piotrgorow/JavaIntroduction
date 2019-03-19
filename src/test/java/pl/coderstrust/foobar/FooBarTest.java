package pl.coderstrust.foobar;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FooBarTest {

    @Test
    public void shouldReturn15LinesWhen15IsPassed() {
        //given
        String[] expectedArray = {"0 FooBar", "1 ", "2 ", "3 Foo", "4 ", "5 Bar", "6 Foo", "7 ", "8 ", "9 Foo", "10 Bar", "11 ", "12 Foo", "13 ", "14 ", "15 FooBar"};

        //when
        String[] result = FooBar.printFooBar(15);

        //then
        assertThat(result, is(expectedArray));
    }

    @Test
    public void shouldReturn1LineWhen0IsPassed() {
        //given
        String[] expectedArray = {"0 FooBar"};

        //when
        String[] result = FooBar.printFooBar(0);

        //then
        assertThat(result, is(expectedArray));
    }

    @Test
    public void shouldReturnEmptyArrayWhenNegativeNumberIsPassed() {
        //given
        String[] expectedArray = {};

        //when
        String[] result = FooBar.printFooBar(-15);

        //then
        assertThat(result, is(expectedArray));
    }
}