import java.util.Arrays;

public class StringCompressor {

    public int compress(char[] chars) {
        int write = 0; // where to write in chars
        int read = 0;  // read position

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count occurrences of the same character
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // If count > 1, write the count as characters
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        StringCompressor sc = new StringCompressor();
        int newLength = sc.compress(chars);
        System.out.println(newLength); // Output: 6
        System.out.println(Arrays.toString(Arrays.copyOf(chars, newLength)));
    }
}
