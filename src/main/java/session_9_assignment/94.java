import java.util.Scanner;

abstract class Cab {
    static final double MINIMUM_FARE = 100.0;

    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {
        double fare = km * getRate();

        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }

        return fare;
    }
}

interface NightService {
    double NIGHT_SURCHARGE = 0.20;

    double applyNightFare(double fare);
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 10.0;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 14.0;
    }

    @Override
    public double applyNightFare(double fare) {
        return fare * (1 + NIGHT_SURCHARGE);
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    @Override
    double getRate() {
        return 18.0;
    }

    @Override
    public double applyNightFare(double fare) {
        return fare * (1 + NIGHT_SURCHARGE);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;

                case "SEDAN":
                    cab = new Sedan(km);
                    break;

                case "SUV":
                    cab = new SUV(km);
                    break;

                default:
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.applyNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}