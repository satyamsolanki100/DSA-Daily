// File: ValidParenthesisString.java

public class ValidParenthesisString {

    public static boolean checkValidString(String s) {

        int low = 0, high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            } 
            else if (ch == ')') {
                low--;
                high--;
            } 
            else { // '*'
                low--;      // treat as ')'
                high++;     // treat as '('
            }

            if (high < 0) return false;

            low = Math.max(low, 0);
        }

        return low == 0;
    }

    public static void main(String[] args) {

        System.out.println(checkValidString("()"));    // true
        System.out.println(checkValidString("(*)"));   // true
        System.out.println(checkValidString("(*))"));  // true
    }
}