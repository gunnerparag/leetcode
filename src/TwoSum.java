import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the complement and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];

            // Check if the complement exists in the HashMap
            if (map.containsKey(complement)) {
                // Return the indices if found
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current number and its index
            map.put(nums[i], i);
        }

        // If no solution is found (per problem description, this won't happen)
        throw new IllegalArgumentException("No two sum solution");
    }

    // Main method for testing
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test case
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);

        // Print the result
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
