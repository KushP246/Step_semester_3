
public class Factorial {
    static void calculateFactorial(int num) {
        long factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        System.out.println(factorial);
    }

    public static void main(String[] args) {
        calculateFactorial(5);
        calculateFactorial(0);
    }
}
