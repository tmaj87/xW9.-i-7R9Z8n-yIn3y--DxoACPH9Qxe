package pl.tmaj;

import pl.tmaj.with.Divided;
import pl.tmaj.with.InRange;
import pl.tmaj.with.MultipleParts;
import pl.tmaj.with.Operation;

import java.util.List;

public class Part {

    private final List<Operation> operations;

    protected Part(int limit) {
        operations = List.of(new Divided(limit), new MultipleParts(), new InRange());
    }

    public String evaluate(String part) {
        return operations.stream()
                .filter(operation -> operation.test(part))
                .findFirst()
                .map(operation -> operation.result(part))
                .orElse(part);
    }
}
