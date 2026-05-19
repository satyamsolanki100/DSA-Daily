import java.util.Stack;

public class PostfixToPrefix {

    // Check operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Conversion function
    public static String postfixToPrefix(String exp) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            }

            // Operator
            else if (isOperator(ch)) {

                String op2 = stack.pop();
                String op1 = stack.pop();

                String temp = ch + op1 + op2;
                stack.push(temp);
            }
        }

        return stack.peek();
    }

    // Main method
    public static void main(String[] args) {

        System.out.println(postfixToPrefix("ab+"));       // +ab
        System.out.println(postfixToPrefix("abc*+d-"));   // -+a*bcd
    }
}