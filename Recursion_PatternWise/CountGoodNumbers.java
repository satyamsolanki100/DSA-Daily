public class CountGoodNumbers {

    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPart = power(5, evenCount);
        long oddPart = power(4, oddCount);

        return (int)((evenPart * oddPart) % MOD);
    }

    // Fast Power (Binary Exponentiation)
    private long power(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}