package pl.tmaj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CronDescriberTest {

    @Test
    void shouldReturnMinutes() {
        CronDescriber cronDescriber = new CronDescriber("15");
        assertEquals("15", cronDescriber.getMinutes());
    }

    @Test
    void shouldParseAsterisk() {
        CronDescriber cronDescriber = new CronDescriber("*/15");
        assertEquals("0 15 30 45", cronDescriber.getMinutes());
    }

    @Test
    void shouldParseMultipleValues() {
        CronDescriber cronDescriber = new CronDescriber("1,15");
        assertEquals("1 15", cronDescriber.getMinutes());
    }

    @Test
    void shouldParseRangeOfValues() {
        CronDescriber cronDescriber = new CronDescriber("1-5");
        assertEquals("1 2 3 4 5", cronDescriber.getMinutes());
    }
}