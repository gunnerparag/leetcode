public class ReverseOfAString {
    public String reverseWords(String s) {
        // Trim the input string to remove leading/trailing spaces
        s = s.trim();
        // Split the string into words based on spaces (handles multiple spaces)
        String[] words = s.split("\\s+");
        // Reverse the words array
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" "); // Add a single space between words
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        ReverseOfAString solution = new ReverseOfAString();
        System.out.println(solution.reverseWords("  the sky   is blue  ")); // Output: "blue is sky the"
        System.out.println(solution.reverseWords("hello world"));          // Output: "world hello"
        System.out.println(solution.reverseWords("a good   example"));     // Output: "example good a
}

}
