
public class LeapYear {
    static void checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) ||
            year % 400 == 0) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }

    public static void main(String[] args) {
        checkLeapYear(2024);
        checkLeapYear(1900);
        checkLeapYear(2000);
    }
}
