package pl.coderstrust.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SortingTestBase {

    public abstract SortingMethod getSortingMethod();

    @ParameterizedTest
    @MethodSource("parameters")
    public void shouldSortSimpleArray(int[] given, int[] expected) {
        // when
        long startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(given);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

        // then
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{28, 46, 63, 41, 13, 12, 53, 65, 60}, new int[]{12, 13, 28, 41, 46, 53, 60, 63, 65}),
                Arguments.of(new int[]{-28, -46, -63, -41, -13, -12, -53, -65, -60}, new int[]{-65, -63, -60, -53, -46, -41, -28, -13, -12}),
                Arguments.of(new int[]{-29, 31, -99, 64, -26, 68, -15, 18, -65, 87, -47}, new int[]{-99, -65, -47, -29, -26, -15, 18, 31, 64, 68, 87})
        );
    }
}
