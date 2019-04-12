package pl.coderstrust.regex;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegexTest {

    @ParameterizedTest
    @MethodSource("parameters")
    public void shouldVerifyIfStringIsProperIPAddress(String given, boolean expected) {
        //given
        Regex regex = new Regex();

        //when
        boolean result = regex.isIpAddress(given);

        //then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("192.168.0.1", true),
                Arguments.of("192.168.0", false),
                Arguments.of("192.168.000.000", true),
                Arguments.of("1.1.0.0", true),
                Arguments.of("001.001.000.000", true),
                Arguments.of("192.168.0.256", false),
                Arguments.of("192.168.256.1", false),
                Arguments.of("192.256.0.1", false),
                Arguments.of("256.168.0.1", false),
                Arguments.of("0.10.100.200", true),
                Arguments.of("249.250.255.99", true),
                Arguments.of("255.168.00.255", true),
                Arguments.of("000..0.256", false),
                Arguments.of("019.01.0.1.", false),
                Arguments.of(".019.01.0.1", false)
        );
    }

    @Test
    @Disabled
    public void shouldTestEveryValue() {
        Regex regex = new Regex();
        for (int i = 0; i < 256; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 256; j++) {
                if (j % 10 == 0) {
                    System.out.print(".");
                }
                for (int k = 0; k < 256; k++) {
                    for (int l = 0; l < 256; l++) {
                        if (!regex.isIpAddress(i + "." + j + "." + k + "." + l)) {
                            System.out.println();
                            System.out.println("Error on address: " + i + "." + j + "." + k + "." + l);
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
