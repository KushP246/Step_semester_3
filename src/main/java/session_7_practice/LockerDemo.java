
import java.util.*;

class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode)) {
            code = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        String code = sc.next();

        Locker l = new Locker(number, code);

        for (int i = 0; i < 2; i++) {
            String oldCode = sc.next();
            String newCode = sc.next();

            if (l.changeCode(oldCode, newCode)) {
                System.out.println("Code changed successfully");
            } else {
                System.out.println("Code change rejected");
            }
        }

        sc.close();
    }
}
