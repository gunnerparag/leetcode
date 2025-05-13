public class SubsequenceChecker {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        SubsequenceChecker checker = new SubsequenceChecker();

        System.out.println(checker.isSubsequence("ace", "abcde"));
        System.out.println(checker.isSubsequence("aec", "abcde"));
    }
}
