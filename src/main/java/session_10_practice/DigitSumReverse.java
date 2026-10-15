
public class DigitSumReverse {
    public static void main(String[] args) {
        int num = 4721;
        int sum = 0;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;

            sum += digit;
            reverse = reverse * 10 + digit;

            num /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }
}
