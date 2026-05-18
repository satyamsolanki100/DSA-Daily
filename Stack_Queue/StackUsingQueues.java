import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push operation
    public void push(int x) {
        q2.add(x);

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation
    public int pop() {
        return q1.remove();
    }

    // Top operation
    public int top() {
        return q1.peek();
    }

    // Check if empty
    public boolean empty() {
        return q1.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());   // 2
        System.out.println(stack.pop());   // 2
        System.out.println(stack.empty()); // false
    }
}