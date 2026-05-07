
public class ReverseNodesInKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        // Check if we have at least k nodes
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head; // not enough nodes
            temp = temp.next;
        }

        // Reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Recursively process remaining list
        head.next = reverseKGroup(curr, k);

        return prev; // new head
    }
}