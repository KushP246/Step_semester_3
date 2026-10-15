
import java.util.*;

abstract class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, java.util.function.Function<Scanner, Delivery>> types =
            new HashMap<>();

        types.put("STANDARD",
            s -> new StandardDelivery(s.nextDouble(), s.nextDouble()));

        types.put("EXPRESS",
            s -> new ExpressDelivery(s.nextDouble(), s.nextDouble()));

        types.put("INTERNATIONAL",
            s -> new InternationalDelivery(
                s.nextDouble(), s.nextDouble(), s.nextDouble()));

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            Delivery d = types.get(type).apply(sc);
            double fee = d.calculateFee();

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
