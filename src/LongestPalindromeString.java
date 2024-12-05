public class LongestPalindromeString {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }

            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                // Check for odd-length palindromes
                int len1 = expandAroundCenter(s, i, i);
                // Check for even-length palindromes
                int len2 = expandAroundCenter(s, i, i + 1);
                // Get the maximum length
                int len = Math.max(len1, len2);

                // Update start and end indices of the longest palindrome found
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // Length of the palindrome is (right - left - 1)
            return right - left - 1;
        }

        public static void main(String[] args) {
            LongestPalindromeString solution = new LongestPalindromeString();
            System.out.println(solution.longestPalindrome("babad")); // Output: "bab" or "aba"
            System.out.println(solution.longestPalindrome("cbbd"));  // Output: "bb"
            System.out.println(solution.longestPalindrome("a"));     // Output: "a"
            System.out.println(solution.longestPalindrome("ac"));    // Output: "a" or "c"
        }
    }

