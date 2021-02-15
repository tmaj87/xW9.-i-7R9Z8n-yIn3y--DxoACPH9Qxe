package pl.tmaj.parts;

import pl.tmaj.operations.*;

import java.util.List;

public class Part {

    private final List<Operation> operations;

    protected Part(int limit) {
        operations = List.of(new Divided(limit), new MultipleParts(), new InRange(), new Asterisk(limit));
    }

    public String evaluate(String part) {
        return operations.stream()
                .filter(operation -> operation.test(part))
                .findFirst()
                .map(operation -> operation.result(part))
                .orElse(part);
    }
}
