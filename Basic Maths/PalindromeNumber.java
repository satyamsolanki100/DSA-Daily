// Problem: Palindrome Number
// Platform: LeetCode
// Approach: Reverse the number and compare
// Time Complexity: O(log10 n)
// Space Complexity: O(1)

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int copy = x;

        while (x > 0) {
            int rem = x % 10;
            reverse = reverse * 10 + rem;
            x = x / 10;
        }

        return copy == reverse;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}