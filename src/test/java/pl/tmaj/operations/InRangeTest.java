package pl.tmaj.operations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InRangeTest {

    private static final String VALUE = "1-5";

    private final Operation inRange = new InRange();

    @Test
    void shouldBeApplicable() {
        assertTrue(inRange.test(VALUE));
    }

    private static Stream<Arguments> testConditions() {
        return Stream.of(
                Arguments.of("1 2 3 4 5", "1-5"),
                Arguments.of("4 5 6 7 8 9", "4-9"),
                Arguments.of("11 12", "11-12")
        );
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    void shouldDisplayRange(String expected, String value) {
        assertEquals(expected, inRange.result(value));
    }
}