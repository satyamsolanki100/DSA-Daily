public class LargestOddNumberInString {

    public String largestOddNumber(String num) {

        // Traverse from right to left
        for (int i = num.length() - 1; i >= 0; i--) {

            int digit = num.charAt(i) - '0';

            // Check if digit is odd
            if (digit % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return ""; // no odd number found
    }

    public static void main(String[] args) {
        LargestOddNumberInString obj = new LargestOddNumberInString();

        System.out.println(obj.largestOddNumber("52"));     
        // Output: 5

        System.out.println(obj.largestOddNumber("4206"));   
        // Output: ""

        System.out.println(obj.largestOddNumber("35427"));  
        // Output: 35427
    }
}