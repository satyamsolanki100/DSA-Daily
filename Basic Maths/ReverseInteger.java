// package Basic Maths;

public class ReverseInteger {
  // Problem: Reverse Integer
// Platform: LeetCode
// Approach: Digit Extraction with Overflow Check
// Time Complexity: O(log10 n)
// Space Complexity: O(1)



    public static int reverse(int x) {

        int rev = 0;

        while (x != 0) {

            int rem = x % 10;

            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }

            rev = rev * 10 + rem;
            x = x / 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }
}
