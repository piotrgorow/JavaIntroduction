package pl.coderstrust.ipadress;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IpAddressValidatorTest {

    @ParameterizedTest
    @MethodSource("invalidIpAddresses")
    void shouldReturnFalseForInvalidIpAddresses(String ipAddress) {
        //when
        boolean result = IpAddressValidator.isIpAddress(ipAddress);

        //then
        assertFalse(result);
    }

    private static Stream<Arguments> invalidIpAddresses() {
        return Stream.of(
                Arguments.of("192.168.0"),
                Arguments.of("192.168.0.256"),
                Arguments.of("192.168.256.1"),
                Arguments.of("192.256.0.1"),
                Arguments.of("256.168.0.1"),
                Arguments.of("000..0.256"),
                Arguments.of("019.01.0.1."),
                Arguments.of(".019.01.0.1")
        );
    }

    @ParameterizedTest
    @MethodSource("validIpAddresses")
    void shouldReturnTrueForValidIpAddresses(String ipAddress) {
        //when
        boolean result = IpAddressValidator.isIpAddress(ipAddress);

        //then
        assertTrue(result);
    }

    private static Stream<Arguments> validIpAddresses() {
        return Stream.of(
                Arguments.of("192.168.0.1"),
                Arguments.of("192.168.000.000"),
                Arguments.of("1.1.0.0"),
                Arguments.of("001.001.000.000"),
                Arguments.of("0.10.100.200"),
                Arguments.of("249.250.255.99"),
                Arguments.of("255.168.00.255")
        );
    }

    @Test
    void shouldThrowExceptionForInvalidArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> IpAddressValidator.isIpAddress(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"%d.1.1.1", "1.%d.1.1", "1.1.%d.1", "1.1.1.%d"})
    void smartTestForValidIpAddresses(String ipAddressTemplate) {
        for (int i = 0; i < 256; i++) {
            assertTrue(IpAddressValidator.isIpAddress(String.format(ipAddressTemplate, i)));
        }
    }

    @Test
    @Disabled
    void shouldReturnTrueForAllCombinationsOfIpAddress() {
        String ipAddress;
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                for (int k = 0; k < 256; k++) {
                    for (int l = 0; l < 256; l++) {
                        ipAddress = String.format("%d.%d.%d.%d", i, j, k, l);
                        assertTrue(IpAddressValidator.isIpAddress(ipAddress));
                    }
                }
            }
        }
    }
}
