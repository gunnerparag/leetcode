import java.util.Arrays;

public class AddSpacesToString {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0; // Pointer for the spaces array
        int n = spaces.length;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            // If the current index matches the next space position
            if (spaceIndex < n && i == spaces[spaceIndex]) {
                result.append(" "); // Add a space
                spaceIndex++; // Move to the next space index
            }
            result.append(s.charAt(i)); // Append the current character
        }

        return result.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        AddSpacesToString solution = new AddSpacesToString();

        // Test cases
        System.out.println("Result: " + solution.addSpaces("leetcode", new int[]{4}));
        // Output: "leet code"

        System.out.println("Result: " + solution.addSpaces("hello", new int[]{1, 3}));
        // Output: "h el lo"

        System.out.println("Result: " + solution.addSpaces("spacing", new int[]{1, 5}));
        // Output: "s pacing"
    }
}