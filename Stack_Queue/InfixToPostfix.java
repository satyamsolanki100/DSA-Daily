import java.util.Stack;

public class InfixToPostfix {

    // Function to check precedence
    public static int precedence(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return -1;
    }

    // Function to convert infix to postfix
    public static String infixToPostfix(String exp) {

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

            // Operand (a-z or 0-9)
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }

            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            }

            // Operator
            else {
                while (!stack.isEmpty() &&
                       ((precedence(ch) < precedence(stack.peek())) ||
                       (precedence(ch) == precedence(stack.peek()) && ch != '^'))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Main method
    public static void main(String[] args) {

        System.out.println(infixToPostfix("a+b*c"));   // abc*+
        System.out.println(infixToPostfix("(a+b)*c")); // ab+c*
    }
}