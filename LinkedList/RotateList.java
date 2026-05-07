public class RotateList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;

        // 1. Find length
        ListNode curr = head;
        int length = 1;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // 2. Make circular
        curr.next = head;

        // 3. Reduce k
        k = k % length;

        // 4. Find new tail (length - k - 1)
        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // 5. Break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}