import java.util.Stack;

public class PrefixToPostfix {

    // Check operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Conversion function
    public static String prefixToPostfix(String exp) {

        Stack<String> stack = new Stack<>();

        // Traverse from right to left
        for (int i = exp.length() - 1; i >= 0; i--) {

            char ch = exp.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            }

            // Operator
            else if (isOperator(ch)) {

                String op1 = stack.pop();
                String op2 = stack.pop();

                String temp = op1 + op2 + ch;
                stack.push(temp);
            }
        }

        return stack.peek();
    }

    // Main method
    public static void main(String[] args) {

        System.out.println(prefixToPostfix("+ab"));       // ab+
        System.out.println(prefixToPostfix("*+ab-cd"));   // ab+cd-*
    }
}