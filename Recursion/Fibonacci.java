// Problem: Fibonacci Number
// Platform: LeetCode
// Approach: Recursion
// Time Complexity: O(2^n)
// Space Complexity: O(n)

public class Fibonacci {

    public static int fib(int n) {

        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
    }
}