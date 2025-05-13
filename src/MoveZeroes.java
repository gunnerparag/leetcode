import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap only if necessary
                if (i != lastNonZeroIndex) {
                    int temp = nums[i];
                    nums[i] = nums[lastNonZeroIndex];
                    nums[lastNonZeroIndex] = temp;
                }
                lastNonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
