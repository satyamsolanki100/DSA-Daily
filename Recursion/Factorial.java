// Problem: Factorial of a Number
// Platform: TUF
// Approach: Functional Recursion
// Time Complexity: O(n)
// Space Complexity: O(n)

public class Factorial {

    public static int factorial(int n) {

        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }
}