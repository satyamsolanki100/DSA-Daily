import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push operation
    public void push(int x) {
        s1.push(x);
    }

    // Pop operation
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // Peek operation
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Check if empty
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {

        QueueUsingStacks queue = new QueueUsingStacks();

        queue.push(1);
        queue.push(2);

        System.out.println(queue.peek());   // 1
        System.out.println(queue.pop());    // 1
        System.out.println(queue.empty());  // false
    }
}