public class ArraySelfService {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Compute prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Compute suffix products and combine with prefix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ArraySelfService solution = new ArraySelfService();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        for (int r : result) {
            System.out.print(r + " ");
        }
        // Output: 24 12 8 6
    }
}
