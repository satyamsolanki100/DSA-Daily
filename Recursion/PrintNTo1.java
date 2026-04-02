// Problem: Print N to 1 using Recursion
// Platform: TUF
// Approach: Simple Recursion (print before recursive call)
// Time Complexity: O(n)
// Space Complexity: O(n)

public class PrintNTo1 {

    public static void printNumbers(int n) {

        if (n == 0) {
            return;
        }

        System.out.println(n);
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
    }
}