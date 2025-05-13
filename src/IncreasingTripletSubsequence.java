public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // smallest so far
            } else if (num <= second) {
                second = num; // second smallest
            } else {
                // num > second -> increasing triplet found
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        System.out.println(solution.increasingTriplet(nums));
    }
}
