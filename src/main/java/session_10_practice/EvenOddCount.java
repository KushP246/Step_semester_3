
public class EvenOddCount {
    public static void main(String[] args) {
        int[] nums = {3, 8, 12, 5, 7, 10};

        int even = 0, odd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
