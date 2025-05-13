import java.util.HashMap;
import java.util.Map;

public class MaxOperations {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int complement = k - num;

            if (map.getOrDefault(complement, 0) > 0) {
                operations++;
                map.put(complement, map.get(complement) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        MaxOperations maxOperations = new MaxOperations();
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        System.out.println(maxOperations.maxOperations(nums,k));


    }
}
