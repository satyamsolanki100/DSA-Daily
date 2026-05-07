public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) return null;

        // 1. Insert copy nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // 2. Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 3. Separate lists
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;

        while (curr != null) {
            Node copy = curr.next;

            copyCurr.next = copy;
            copyCurr = copy;

            curr.next = copy.next; // restore original
            curr = curr.next;
        }

        return dummy.next;
    }
}