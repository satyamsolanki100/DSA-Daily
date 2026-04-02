// Problem: Valid Palindrome
// Platform: LeetCode
// Approach: Two Pointers + String Cleaning
// Time Complexity: O(n)
// Space Complexity: O(n)

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        StringBuilder clean = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                clean.append(Character.toLowerCase(c));
            }
        }

        int start = 0;
        int end = clean.length() - 1;

        while (start < end) {
            if (clean.charAt(start) != clean.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}