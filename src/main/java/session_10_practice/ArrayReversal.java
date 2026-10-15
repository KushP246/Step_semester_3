
import java.util.Arrays;

public class ArrayReversal {
    public static void main(String[] args) {
        int[] nums = {11, 22, 33, 44};

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(nums));
    }
}
