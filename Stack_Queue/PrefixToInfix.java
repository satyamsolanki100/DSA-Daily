import java.util.Stack;

public class PrefixToInfix {

    // Function to check operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Conversion function
    public static String prefixToInfix(String exp) {

        Stack<String> stack = new Stack<>();

        // Traverse from right to left
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            // If operand
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            }
            // If operator
            else if (isOperator(ch)) {

                String op1 = stack.pop();
                String op2 = stack.pop();

                String temp = "(" + op1 + ch + op2 + ")";
                stack.push(temp);
            }
        }

        return stack.peek();
    }

    // Main method
    public static void main(String[] args) {

        System.out.println(prefixToInfix("+ab"));       // (a+b)
        System.out.println(prefixToInfix("*+ab-cd"));   // ((a+b)*(c-d))
    }
}