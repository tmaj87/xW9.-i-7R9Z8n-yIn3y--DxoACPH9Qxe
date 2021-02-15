package pl.tmaj;

public class Application {

    public static void main(String[] args) {
        if (args.length > 0) {
            new CronDescriber(args[0]).print();
        } else {
            throw new IllegalArgumentException("Invalid arguments provided");
        }
    }
}
