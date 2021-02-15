package pl.tmaj.operations;

import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

@AllArgsConstructor
public class Divided implements Operation {

    private static final String SPACE = " ";

    private final int limit;

    @Override
    public boolean test(String part) {
        return part.startsWith("*/");
    }

    @Override
    public String result(String part) {
        int asInt = Integer.parseInt(part.substring(2));
        return IntStream.range(0, limit / asInt)
                .map(i -> i * asInt)
                .mapToObj(Objects::toString)
                .collect(joining(SPACE));
    }
}
