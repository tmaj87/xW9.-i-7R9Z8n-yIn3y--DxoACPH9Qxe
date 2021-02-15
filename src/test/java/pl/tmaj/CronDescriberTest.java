package pl.tmaj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CronDescriberTest {

    public static final String FULL_COMMAND = "*/15 0 1,15 * 1-5 /usr/bin/find";

    private final CronDescriber cronDescriber = new CronDescriber(FULL_COMMAND);

    @Test
    void shouldParseMinutes() {
        assertEquals("0 15 30 45", cronDescriber.getMinutes());
    }

    @Test
    void shouldParseHours() {
        assertEquals("0", cronDescriber.getHours());
    }

    @Test
    void shouldParseDayOfMonth() {
        assertEquals("1 15", cronDescriber.getDayOfMonth());
    }

    @Test
    void shouldParseMonth() {
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12", cronDescriber.getMonth());
    }

    @Test
    void shouldParseDayOfWeek() {
        assertEquals("1 2 3 4 5", cronDescriber.getDayOfWeek());
    }

    @Test
    void shouldParseCommand() {
        assertEquals("/usr/bin/find", cronDescriber.getCommand());
    }

    @Test
    void shouldPrint() {
        CronDescriber cronDescriber = new CronDescriber(FULL_COMMAND);
        cronDescriber.print();
    }

    @Test
    void shouldThrowInsufficientPartsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new CronDescriber("1 2"));
    }
}