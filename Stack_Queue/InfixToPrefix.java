import java.util.Stack;

public class InfixToPrefix {

    // Check precedence
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return -1;
    }

    // Reverse string and swap brackets
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(') sb.append(')');
            else if (ch == ')') sb.append('(');
            else sb.append(ch);
        }

        return sb.toString();
    }

    // Infix to Postfix
    public static String infixToPostfix(String exp) {

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : exp.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }

            else {
                while (!stack.isEmpty() &&
                       precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Main conversion function
    public static String infixToPrefix(String exp) {

        String reversed = reverse(exp);
        String postfix = infixToPostfix(reversed);
        return new StringBuilder(postfix).reverse().toString();
    }

    // Main method
    public static void main(String[] args) {

        System.out.println(infixToPrefix("(a+b)*c")); // *+abc
        System.out.println(infixToPrefix("a+b*c"));   // +a*bc
    }
}