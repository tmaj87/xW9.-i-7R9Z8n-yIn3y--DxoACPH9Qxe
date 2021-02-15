package pl.tmaj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CronDescriberTest {

    @Test
    void shouldReturnMinutes() {
        CronDescriber cronDescriber = new CronDescriber("15");
        Assertions.assertEquals("15", cronDescriber.getMinutes());
    }

    @Test
    void shouldParseAsterisk() {
        CronDescriber cronDescriber = new CronDescriber("*/15");
        Assertions.assertEquals("0 15 30 45", cronDescriber.getMinutes());
    }

    @Test
    void shouldParseMultipleValues() {
        CronDescriber cronDescriber = new CronDescriber("1,15");
        Assertions.assertEquals("1 15", cronDescriber.getMinutes());
    }
}