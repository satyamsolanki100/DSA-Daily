public class PowXN {

    public double myPow(double x, int n) {

        long N = n; // handle overflow

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {

        double result = 1.0;

        while (n > 0) {

            // If n is odd
            if ((n % 2) == 1) {
                result *= x;
            }

            x *= x;  // square base
            n /= 2;  // reduce power
        }

        return result;
    }

    public static void main(String[] args) {
        PowXN obj = new PowXN();

        System.out.println(obj.myPow(2.0, 10));  // 1024
        System.out.println(obj.myPow(2.1, 3));   // 9.261
        System.out.println(obj.myPow(2.0, -2));  // 0.25
    }
}