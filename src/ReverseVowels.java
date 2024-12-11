public class ReverseVowels {
    public static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // Move left pointer until a vowel is found
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            // Move right pointer until a vowel is found
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            // Swap the vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "hello";
        String result = reverseVowels(s);
        System.out.println(result); // Output: "holle"
    }
}
