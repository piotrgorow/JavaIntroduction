package pl.coderstrust.ipadress;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IpAddressValidatorTest {

    @ParameterizedTest
    @MethodSource("invalidTestArguments")
    Void shouldReturnFalseForInvalidIpAddresses(String ipAddress) {
        //when
        boolean result = IpAddressValidator.isIpAddress(given);

        //then
        assertFalse(result);
    }

    private static Stream<Arguments> invalidIpAddresses() {
        return Stream.of(
                Arguments.of("192.168.0"),
                Arguments.of("192.168.0.256", false),
                Arguments.of("192.168.256.1", false),
                Arguments.of("192.256.0.1", false),
                Arguments.of("256.168.0.1", false),
                Arguments.of("000..0.256", false),
                Arguments.of("019.01.0.1.", false),
                Arguments.of(".019.01.0.1", false)
        );
    }

    @ParameterizedTest
    @MethodSource("validTestArguments")
    public void shouldReturnTrueForValidIpAddresses(String given, boolean expected) {
        //when
        boolean result = IpAddressValidator.isIpAddress(given);

        //then
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> validTestArguments() {
        return Stream.of(
                Arguments.of("192.168.0.1", true),
                Arguments.of("192.168.000.000", true),
                Arguments.of("1.1.0.0", true),
                Arguments.of("001.001.000.000", true),
                Arguments.of("0.10.100.200", true),
                Arguments.of("249.250.255.99", true),
                Arguments.of("255.168.00.255", true)
        );
    }

    @Test
    public void shouldThrowExceptionForNullArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> IpAddressValidator.isIpAddress(null));
    }

    @Test
    @Disabled
    public void shouldReturnTrueForAllCombinationsOfIpAddress() {
        String ipAddress;
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                for (int k = 0; k < 256; k++) {
                    for (int l = 0; l < 256; l++) {
                        ipAddress = String.format("%d.%d.%d.%d", i, j, k, l);
                        Assertions.assertTrue(IpAddressValidator.isIpAddress(ipAddress));
                    }
                }
            }
        }
    }
}
