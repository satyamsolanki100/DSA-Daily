// package Basic Maths;
// Problem: GCD of Two Numbers
// Platform: TUF / Basic Math
// Approach: Euclidean Algorithm
// Time Complexity: O(log(min(n1, n2)))
// Space Complexity: O(1)

public class GCD {

    public static int gcd(int n1, int n2) {

        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }

        return n1;
    }

    public static void main(String[] args) {
        int n1 = 36;
        int n2 = 24;
        System.out.println(gcd(n1, n2));
    }
}
