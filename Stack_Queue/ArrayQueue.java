public class ArrayQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    // Constructor
    public ArrayQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    // Push operation (enqueue)
    public void push(int x) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[++rear] = x;
    }

    // Pop operation (dequeue)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return queue[front++];
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }

    // Check if empty
    public boolean isEmpty() {
        return front > rear;
    }

    // Main method for testing
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(5);

        queue.push(5);
        queue.push(10);

        System.out.println(queue.peek());   // 5
        System.out.println(queue.pop());    // 5
        System.out.println(queue.isEmpty()); // false
    }
}