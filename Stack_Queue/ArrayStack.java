public class ArrayStack {

    private int[] stack;
    private int top;
    private int capacity;

    // Constructor
    public ArrayStack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    // Push operation
    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = x;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    // Top operation (peek)
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    // Check if empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Main method for testing
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(5);

        stack.push(5);
        stack.push(10);

        System.out.println(stack.top());   // 10
        System.out.println(stack.pop());   // 10
        System.out.println(stack.isEmpty()); // false
    }
}