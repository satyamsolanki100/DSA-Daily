// Problem: Sum of First N Numbers
// Platform: TUF
// Approach: Functional Recursion
// Time Complexity: O(n)
// Space Complexity: O(n)

public class SumOfNNumbers {

    public static int NnumbersSum(int n) {

        if (n == 0) {
            return 0;
        }

        return n + NnumbersSum(n - 1);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(NnumbersSum(n));
    }
}