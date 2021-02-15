package pl.tmaj.with;

public class MultipleParts implements Operation {

    private static final String COMMA = ",";
    private static final String SPACE = " ";

    @Override
    public boolean test(String part) {
        return part.contains(COMMA);
    }

    @Override
    public String result(String part) {
        return String.join(SPACE, part.split(COMMA));
    }
}
