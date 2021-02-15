package pl.tmaj.with;

import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class InRange implements Operation {

    private static final String DASH = "-";
    private static final String SPACE = " ";

    @Override
    public boolean test(String part) {
        return part.contains(DASH);
    }

    @Override
    public String result(String part) {
        int from = Integer.parseInt(part.substring(0, part.indexOf(DASH)));
        int to = Integer.parseInt(part.substring(part.indexOf(DASH) + 1));
        return IntStream.rangeClosed(from, to)
                .mapToObj(Objects::toString)
                .collect(joining(SPACE));
    }
}
