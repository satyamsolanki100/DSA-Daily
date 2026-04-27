public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // Step 1: Remove leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        // Step 3: Convert digits
        long result = 0; // use long to handle overflow

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            // Step 4: Handle overflow
            if (sign * result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        StringToIntegerAtoi obj = new StringToIntegerAtoi();

        System.out.println(obj.myAtoi("42"));          // 42
        System.out.println(obj.myAtoi("   -042"));     // -42
        System.out.println(obj.myAtoi("1337c0d3"));    // 1337
        System.out.println(obj.myAtoi("0-1"));         // 0
        System.out.println(obj.myAtoi("words 987"));   // 0
    }
}