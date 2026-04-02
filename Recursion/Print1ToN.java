// Problem: Print 1 to N using Recursion
// Platform: TUF
// Approach: Backtracking Recursion
// Time Complexity: O(n)
// Space Complexity: O(n)

public class Print1ToN {

    public static void printNumbers(int n) {

        if (n == 0) {
            return;
        }

        printNumbers(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
    }
}