public class DivideTwoIntegers2 {

    public static int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while (dvd >= dvs) {

            long temp = dvs;
            int multiple = 1;

            // Increase divisor exponentially
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            quotient += multiple;
        }

        return isNegative ? -quotient : quotient;
    }

    public static void main(String[] args) {

        System.out.println(divide(10, 3));   // 3
        System.out.println(divide(7, -3));   // -2
    }
}