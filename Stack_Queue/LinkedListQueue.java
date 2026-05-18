public class LinkedListQueue {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    // Constructor
    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    // Push operation (enqueue)
    public void push(int x) {
        Node newNode = new Node(x);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Pop operation (dequeue)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = front.data;
        front = front.next;

        // If queue becomes empty
        if (front == null) {
            rear = null;
        }

        return value;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    // Check if empty
    public boolean isEmpty() {
        return front == null;
    }

    // Main method for testing
    public static void main(String[] args) {

        LinkedListQueue queue = new LinkedListQueue();

        queue.push(3);
        queue.push(7);

        System.out.println(queue.peek());   // 3
        System.out.println(queue.pop());    // 3
        System.out.println(queue.isEmpty()); // false
    }
}