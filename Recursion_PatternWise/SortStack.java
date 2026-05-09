import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();

        // Sort remaining stack
        sortStack(stack);

        // Insert this element correctly
        insertSorted(stack, top);
    }

    private static void insertSorted(Stack<Integer> stack, int value) {

        // If stack empty OR correct position found
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int top = stack.pop();

        // Recurse
        insertSorted(stack, value);

        // Put back removed element
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        sortStack(stack);

        System.out.println(stack); // [1, 2, 3, 4] (bottom → top)
    }
}