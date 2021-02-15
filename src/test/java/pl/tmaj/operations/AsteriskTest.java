package pl.tmaj.operations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AsteriskTest {

    private static final String VALUE = "*";
    private static final int LIMIT = 12;

    private final Operation asterisk = new Asterisk(LIMIT);

    @Test
    void shouldBeApplicable() {
        assertTrue(asterisk.test(VALUE));
    }

    private static Stream<Arguments> testConditions() {
        return Stream.of(
                Arguments.of("1 2 3 4 5 6 7 8 9 10 11 12", new Asterisk(LIMIT)),
                Arguments.of("1 2 3", new Asterisk(3))
        );
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    void shouldDisplayAllValues(String expected, Operation operation) {
        assertEquals(expected, operation.result(VALUE));
    }
}