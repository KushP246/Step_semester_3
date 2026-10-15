import java.util.Scanner;

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0.0;
    }

    String getType() {
        return "STANDARD";
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

interface Insurable {
    double INSURANCE_RATE = 0.02;

    double calculateInsurance();
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 40.0 + 10.0 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 80.0 + 15.0 * weightKg;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * INSURANCE_RATE;
    }

    @Override
    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    double calculateCharge() {
        return 40.0 + 10.0 * weightKg + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * INSURANCE_RATE;
    }

    @Override
    String getType() {
        return "FRAGILE";
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, value);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(weight, value);
                    break;

                case "FRAGILE":
                    parcel = new FragileParcel(weight, value);
                    break;

                default:
                    continue;
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}