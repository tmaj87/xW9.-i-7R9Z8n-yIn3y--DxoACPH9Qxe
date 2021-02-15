package pl.tmaj.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DividedTest {

    private static final String VALUE = "*/15";
    private static final int LIMIT = 60;

    private final Operation divided = new Divided(LIMIT);

    @Test
    void shouldBeApplicable() {
        assertTrue(divided.test(VALUE));
    }

    @Test
    void shouldDivide() {
        assertEquals("0 15 30 45", divided.result(VALUE));
    }
}