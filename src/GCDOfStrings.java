public class GCDOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        // Check if str1 and str2 can have a common divisor
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find the GCD of the lengths of the two strings
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the substring of str1 up to the GCD length
        return str1.substring(0, gcdLength);
    }

    // Helper method to calculate GCD of two numbers
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        String result = gcdOfStrings(str1, str2);
        System.out.println(result); // Output: "AB"
    }
}
