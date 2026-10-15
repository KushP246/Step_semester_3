import java.util.Scanner;

abstract class Student {
    protected String name;

    static final double TUITION_FEE = 40000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    String getName() {
        return name;
    }
}

interface BusUser {
    double TRANSPORT_FEE = 12000.0;

    boolean usesBus();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return TUITION_FEE + BusUser.TRANSPORT_FEE;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    static final double HOSTEL_FEE = 60000.0;

    Hosteller(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return TUITION_FEE + HOSTEL_FEE;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return (TUITION_FEE / 2) + BusUser.TRANSPORT_FEE;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new Scholar(name);
                    break;

                default:
                    continue;
            }

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n",
                    student.getName(), fee);

            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n",
                totalCollected);

        sc.close();
    }
}