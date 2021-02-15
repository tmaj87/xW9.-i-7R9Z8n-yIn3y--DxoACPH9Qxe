package pl.tmaj.operations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultiplePartsTest {

    private static final String VALUE = "1,15";

    private final Operation multipleParts = new MultipleParts();

    @Test
    void shouldBeApplicable() {
        assertTrue(multipleParts.test(VALUE));
    }

    private static Stream<Arguments> testConditions() {
        return Stream.of(
                Arguments.of("1 15", VALUE),
                Arguments.of("4 5 8", "4,5,8")
        );
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    void shouldCombineParts(String expected, String value) {
        assertEquals(expected, multipleParts.result(value));
    }
}