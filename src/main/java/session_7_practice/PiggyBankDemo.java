
import java.util.*;

class PiggyBank {
    private int savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
            return true;
        }
        return false;
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

public class PiggyBankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = sc.next();
        PiggyBank pb = new PiggyBank(id);

        int deposit = sc.nextInt();
        pb.deposit(deposit);
        System.out.println("Savings: " + pb.getSavings());

        int withdrawal1 = sc.nextInt();
        if (pb.withdraw(withdrawal1)) {
            System.out.println("Savings: " + pb.getSavings());
        } else {
            System.out.println("Withdrawal rejected");
        }

        int withdrawal2 = sc.nextInt();
        if (pb.withdraw(withdrawal2)) {
            System.out.println("Savings: " + pb.getSavings());
        } else {
            System.out.println("Withdrawal rejected");
            System.out.println("Savings: " + pb.getSavings());
        }

        sc.close();
    }
}
