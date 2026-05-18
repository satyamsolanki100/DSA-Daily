public class LinkedListStack {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Top of stack

    // Constructor
    public LinkedListStack() {
        head = null;
    }

    // Push operation
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    // Top operation
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return head.data;
    }

    // Check if empty
    public boolean isEmpty() {
        return head == null;
    }

    // Main method for testing
    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(3);
        stack.push(7);

        System.out.println(stack.pop());    // 7
        System.out.println(stack.top());    // 3
        System.out.println(stack.isEmpty()); // false
    }
}