package pl.tmaj;

public class Application {

    public static void main(String[] args) {
        if (args.length > 0) {
            new CronDescriber(args[0]);
        } else {
            throw new IllegalArgumentException("Invalid arguments provided");
        }
    }
}
