package pl.tmaj;

import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class CronDescriber {

    private static final String SEPARATOR = " ";
    private static final int MINUTES_INDEX = 0;
    private static final int MAX_MINUTES = 60;
    private static final Predicate<String> WITH_ASTERISK = value -> value.startsWith("*/");

    private final List<String> parts;

    public CronDescriber(String arguments) {
        parts = List.of(arguments.split(SEPARATOR));
    }

    public String getMinutes() {
        String part = parts.get(MINUTES_INDEX);
        if (WITH_ASTERISK.test(part)) {
            return minutesWithAsterisk(part);
        }
        return part;
    }

    private String minutesWithAsterisk(String part) {
        int asInt = parsePart(part);
        return IntStream.range(0, MAX_MINUTES / asInt)
                .map(i -> i * asInt)
                .mapToObj(Objects::toString)
                .collect(joining(" "));
    }

    private int parsePart(String part) {
        return Integer.parseInt(part.substring(2));
    }
}
