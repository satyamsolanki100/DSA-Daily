import java.util.Stack;

public class ReverseStack {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();

        // Reverse remaining stack
        reverse(stack);

        // Insert this element at bottom
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack, int value) {

        // Base case
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int top = stack.pop();

        // Recurse
        insertAtBottom(stack, value);

        // Put back removed element
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        reverse(stack);

        System.out.println(stack); // [2, 3, 1, 4]
    }
}