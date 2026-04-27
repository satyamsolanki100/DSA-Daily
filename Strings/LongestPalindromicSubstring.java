public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome
            int len1 = expandFromCenter(s, i, i);

            // Case 2: Even length palindrome
            int len2 = expandFromCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() 
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();

        System.out.println(obj.longestPalindrome("babad")); // bab / aba
        System.out.println(obj.longestPalindrome("cbbd"));  // bb
    }
}