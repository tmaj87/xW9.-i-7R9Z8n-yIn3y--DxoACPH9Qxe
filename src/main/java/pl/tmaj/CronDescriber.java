package pl.tmaj;

import pl.tmaj.parts.*;

import java.util.List;

public class CronDescriber {

    private static final String SPACE = " ";

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
        return new DaysOfWeek().evaluate(part);
    }

    public String getCommand() {
        return parts.get(5);
    }

    public void print() {
        System.out.printf("minute\t\t\t%s%n", getMinutes());
        System.out.printf("hour\t\t\t%s%n", getHours());
        System.out.printf("day of month\t%s%n", getDayOfMonth());
        System.out.printf("month\t\t\t%s%n", getMonth());
        System.out.printf("day of week\t\t%s%n", getDayOfWeek());
        System.out.printf("command\t\t\t%s%n", getCommand());
    }
}
