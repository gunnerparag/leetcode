public class MaxAverageSubArray {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        double windowSum = 0;

        // Initial window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        MaxAverageSubArray solution = new MaxAverageSubArray();
        System.out.println(solution.findMaxAverage(nums, k));
    }
}
