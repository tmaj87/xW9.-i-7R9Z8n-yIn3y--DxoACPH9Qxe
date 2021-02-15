package pl.tmaj.with;

import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Divided implements Operation {

    private static final String SPACE = " ";
    private static final int MAX_MINUTES = 60;

    @Override
    public boolean test(String part) {
        return part.startsWith("*/");
    }

    @Override
    public String result(String part) {
        int asInt = Integer.parseInt(part.substring(2));
        return IntStream.range(0, MAX_MINUTES / asInt)
                .map(i -> i * asInt)
                .mapToObj(Objects::toString)
                .collect(joining(SPACE));
    }
}
