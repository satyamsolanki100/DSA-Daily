import java.util.*;

public class PrimeFactorization {

    // Function to get prime factors of a number
    public static List<Integer> getPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        // Step 1: Handle factor 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Step 2: Check odd numbers from 3 to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // Step 3: If remaining n > 1
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    public static List<List<Integer>> primeFactorization(int[] queries) {
        List<List<Integer>> result = new ArrayList<>();

        for (int num : queries) {
            result.add(getPrimeFactors(num));
        }

        return result;
    }

    public static void main(String[] args) {

        int[] queries1 = {2, 3, 4, 5, 6};
        System.out.println(primeFactorization(queries1));

        int[] queries2 = {7, 12, 18};
        System.out.println(primeFactorization(queries2));
    }
}