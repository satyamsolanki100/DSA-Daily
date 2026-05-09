public class StringToIntegerAtoi {

    public int myAtoi(String s) {

        int i = 0, n = s.length();

        // 1. Skip whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits
        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // 4. Handle overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        StringToIntegerAtoi obj = new StringToIntegerAtoi();

        System.out.println(obj.myAtoi("42"));        // 42
        System.out.println(obj.myAtoi("   -042"));   // -42
        System.out.println(obj.myAtoi("1337c0d3"));  // 1337
        System.out.println(obj.myAtoi("0-1"));       // 0
        System.out.println(obj.myAtoi("words"));     // 0
    }
}