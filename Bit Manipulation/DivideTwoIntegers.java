public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        // Edge case (overflow)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert to long to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = 0;

        while (dvd >= dvs) {

            int shift = 0;

            // Find max shift
            while (dvd >= (dvs << (shift + 1))) {
                shift++;
            }

            // Add to result
            result += (1 << shift);

            // Subtract
            dvd -= (dvs << shift);
        }

        // Apply sign
        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        return result;
    }

    public static void main(String[] args) {

        DivideTwoIntegers obj = new DivideTwoIntegers();

        System.out.println(obj.divide(10, 3)); // 3
        System.out.println(obj.divide(7, -3)); // -2
    }
}