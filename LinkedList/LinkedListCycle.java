public class LinkedListCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // Floyd’s Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) return true; // cycle detected
        }

        return false; // no cycle
    }

    public static void main(String[] args) {
        LinkedListCycle obj = new LinkedListCycle();

        // Create nodes
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Link nodes
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create cycle: node4 -> node2
        node4.next = node2;

        System.out.println(obj.hasCycle(head)); 
        // Output: true
    }
}