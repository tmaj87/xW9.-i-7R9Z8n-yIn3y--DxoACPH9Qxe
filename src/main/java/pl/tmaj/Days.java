package pl.tmaj;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Getter
@AllArgsConstructor
enum Days {

    MONDAY("Mon", "1"),
    TUESDAY("Tue", "2"),
    WEDNESDAY("Wed", "3"),
    THURSDAY("Thu", "4"),
    FRIDAY("Fri", "5"),
    SATURDAY("Sat", "6"),
    SUNDAY("Sun", "7");

    public static final List<Days> all;
    static {
        all = Stream.of(Days.values())
                .collect(toList());
    }

    private final String dayName;
    private final String replaceTo;
}
