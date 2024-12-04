import java.util.HashMap;


// Two pointer problems
public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); // To store the last seen position of each character
        int maxLen = 0; // To store the maximum length
        int left = 0; // Left pointer of the window

        // Traverse the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // If the character is already in the map, adjust the left pointer
            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }

            // Update the character's position in the map
            map.put(current, right);

            // Update the maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Main method for testing
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        // Test cases
        System.out.println("Result: " + solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println("Result: " + solution.lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println("Result: " + solution.lengthOfLongestSubstring("pwwkew"));   // Output: 3
        System.out.println("Result: " + solution.lengthOfLongestSubstring(""));         // Output: 0
        System.out.println("Result: " + solution.lengthOfLongestSubstring("dvdf"));     // Output: 3
    }
}
