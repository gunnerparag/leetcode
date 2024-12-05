public class CyclicallyOperation {
    public boolean canMakeSubsequence(String str1, String str2) {
            int n1 = str1.length();
            int n2 = str2.length();
            int i = 0, j = 0;

            while (i < n1 && j < n2) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(j);

                // Check if c1 matches c2 or can be incremented to c2
                if (c1 == c2 || (c1 - 'a' + 1) % 26 == (c2 - 'a')) {
                    j++; // Move pointer for str2
                }
                i++; // Move pointer for str1
            }

            // If we've matched all characters of str2, return true
            return j == n2;
        }

        public static void main(String[] args) {
            CyclicallyOperation solution = new CyclicallyOperation();
            System.out.println(solution.canMakeSubsequence("abc", "abd")); // true
            System.out.println(solution.canMakeSubsequence("abc", "bcd")); // true
            System.out.println(solution.canMakeSubsequence("abc", "def")); // false
            System.out.println(solution.canMakeSubsequence("az", "ba"));   // true
        }
}
