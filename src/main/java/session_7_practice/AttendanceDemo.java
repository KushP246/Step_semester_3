
import java.util.*;

class AttendanceSheet {
    private String[] students;
    private int count;

    AttendanceSheet(int size) {
        students = new String[size];
        count = 0;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void markPresent(String name) {
        if (!isPresent(name) && count < students.length) {
            students[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }
}

public class AttendanceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int n = sc.nextInt();

        AttendanceSheet sheet = new AttendanceSheet(size);

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            sheet.markPresent(name);
        }

        System.out.println("Present Count: " + sheet.getPresentCount());

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            String name = sc.next();
            System.out.println(name + ": " + sheet.isPresent(name));
        }

        sc.close();
    }
}
