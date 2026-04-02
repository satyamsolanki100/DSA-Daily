// Problem: Check Prime Number
// Platform: TUF
// Approach: Check divisibility till sqrt(n)
// Time Complexity: O(sqrt(n))
// Space Complexity: O(1)

public class PrimeNumber {

    public static boolean isPrime(int n) {

        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 29;
        System.out.println(isPrime(n));
    }
}