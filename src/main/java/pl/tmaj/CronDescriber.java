package pl.tmaj;

import pl.tmaj.with.Divided;
import pl.tmaj.with.InRange;
import pl.tmaj.with.MultipleParts;
import pl.tmaj.with.Operation;

import java.util.List;

public class CronDescriber {

    private static final String SPACE = " ";
    private static final int MINUTES_INDEX = 0;

    private final List<Operation> operations = List.of(new Divided(), new MultipleParts(), new InRange());
    private final List<String> parts;

    public CronDescriber(String arguments) {
        parts = List.of(arguments.split(SPACE));
    }

    public String getMinutes() {
        String part = parts.get(MINUTES_INDEX);
        return operations.stream()
                .filter(operation -> operation.test(part))
                .findFirst()
                .map(operation -> operation.result(part))
                .orElse(part);
    }
}
