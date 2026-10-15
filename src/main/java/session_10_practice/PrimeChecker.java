
public class PrimeChecker {
    static void checkPrime(int num) {
        boolean prime = num > 1;

        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime) {
            System.out.println(num + " is prime");
        } else {
            System.out.println(num + " is not prime");
        }
    }

    public static void main(String[] args) {
        checkPrime(29);
        checkPrime(21);
    }
}
