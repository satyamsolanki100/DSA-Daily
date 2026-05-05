public class DeleteTheMiddleNodeOfALinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteMiddle(ListNode head) {

        // Edge case: only one node
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Find middle node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete middle node
        prev.next = slow.next;

        return head;
    }

    // Helper function to print list
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DeleteTheMiddleNodeOfALinkedList obj = new DeleteTheMiddleNodeOfALinkedList();

        // Example: 1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        head = obj.deleteMiddle(head);

        obj.printList(head);
        // Output: 1 -> 3 -> 4 -> 1 -> 2 -> 6 -> null
    }
}