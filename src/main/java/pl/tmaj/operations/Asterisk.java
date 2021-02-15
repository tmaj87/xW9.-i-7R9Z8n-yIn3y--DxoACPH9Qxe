package pl.tmaj.operations;

import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

@AllArgsConstructor
public class Asterisk implements Operation {

    private static final String SPACE = " ";

    private final int limit;

    @Override
    public boolean test(String part) {
        return "*".equals(part);
    }

    @Override
    public String result(String part) {
        return IntStream.rangeClosed(1, limit)
                .mapToObj(Objects::toString)
                .collect(joining(SPACE));
    }
}
