package pl.tmaj;

import java.util.List;

public class CronDescriber {

    private static final String SPACE = " ";
    private static final int MINUTES_INDEX = 0;

    private final List<String> parts;

    public CronDescriber(String arguments) {
        parts = List.of(arguments.split(SPACE));
    }

    public String getMinutes() {
        String part = parts.get(MINUTES_INDEX);
        return new Minutes().evaluate(part);
    }
}
