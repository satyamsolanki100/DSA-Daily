public class LargestOddNumberInString {

    public String largestOddNumber(String num) {
        // Traverse from right to left
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);

            // Check if digit is odd
            if ((ch - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return ""; // no odd number found
    }

    public static void main(String[] args) {
        LargestOddNumberInString obj = new LargestOddNumberInString();

        System.out.println(obj.largestOddNumber("52"));    // "5"
        System.out.println(obj.largestOddNumber("4206"));  // ""
        System.out.println(obj.largestOddNumber("35427")); // "35427"
    }
}