package pl.tmaj;

import pl.tmaj.parts.*;

import java.util.List;
import java.util.Optional;

public class CronDescriber {

    private static final String SPACE = " ";
    private static final String YEAR_REGEX = "^[0-9]{4}$";

    private final List<String> parts;

    public CronDescriber(String arguments) {
        String[] parts = arguments.split(SPACE);
        if (parts.length < 6) {
            throw new IllegalArgumentException("Insufficient Cron Parts");
        }
        this.parts = List.of(parts);
    }

    public String getMinutes() {
        String part = parts.get(0);
        return new Minutes().evaluate(part);
    }

    public String getHours() {
        String part = parts.get(1);
        return new Hours().evaluate(part);
    }

    public String getDayOfMonth() {
        String part = parts.get(2);
        return new DaysOfMonth().evaluate(part);
    }

    public String getMonth() {
        String part = parts.get(3);
        return new Months().evaluate(part);
    }

    public String getDayOfWeek() {
        String part = parts.get(4);
        String translated = translateDaysOfWeek(part);
        return new DaysOfWeek().evaluate(translated);
    }

    private String translateDaysOfWeek(String part) {
        part = part.replace("Mon", "1");
        part = part.replace("Tue", "2");
        part = part.replace("Wed", "3");
        part = part.replace("Thu", "4");
        part = part.replace("Fri", "5");
        part = part.replace("Sat", "6");
        part = part.replace("Sun", "7");
        return part;
    }

    public Optional<String> getYear() {
        String part = parts.get(5);
        if (part.matches(YEAR_REGEX)) {
            return Optional.of(part);
        }
        return Optional.empty();
    }

    public String getCommand() {
        return getYear().isPresent()
                ? parts.get(6)
                : parts.get(5);
    }

    public void print() {
        System.out.printf("minute\t\t\t%s%n", getMinutes());
        System.out.printf("hour\t\t\t%s%n", getHours());
        System.out.printf("day of month\t%s%n", getDayOfMonth());
        System.out.printf("month\t\t\t%s%n", getMonth());
        System.out.printf("day of week\t\t%s%n", getDayOfWeek());
        getYear().ifPresent(year -> System.out.printf("year\t\t\t%s%n", year));
        System.out.printf("command\t\t\t%s%n", getCommand());
    }
}
