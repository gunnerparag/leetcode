public class PicesMovingString {
        public boolean canTransform(String start, String target) {
            // Remove the '_' characters and check if the sequence of 'L' and 'R' matches
            if (!start.replace("_", "").equals(target.replace("_", ""))) {
                return false;
            }

            int n = start.length();
            int i = 0, j = 0;

            while (i < n && j < n) {
                // Skip '_' characters in both strings
                while (i < n && start.charAt(i) == '_') {
                    i++;
                }
                while (j < n && target.charAt(j) == '_') {
                    j++;
                }

                // If one string is exhausted before the other, it's not transformable
                if (i < n && j < n) {
                    if (start.charAt(i) != target.charAt(j)) {
                        return false;
                    }
                    // Check movement constraints
                    if (start.charAt(i) == 'L' && i < j) {
                        return false;
                    }
                    if (start.charAt(i) == 'R' && i > j) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }

            // Ensure both strings are fully processed
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            return i == j;
        }

        public static void main(String[] args) {
            PicesMovingString solution = new PicesMovingString();
            System.out.println(solution.canTransform("R_L_", "_RL_")); // true
            System.out.println(solution.canTransform("_L__R", "L__R_")); // false
            System.out.println(solution.canTransform("R__L", "__LR")); // false
        }

}
