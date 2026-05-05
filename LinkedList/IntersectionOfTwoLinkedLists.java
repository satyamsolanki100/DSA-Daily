public class IntersectionOfTwoLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Edge case
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists
        while (a != b) {
            // If a reaches end, switch to headB
            a = (a == null) ? headB : a.next;

            // If b reaches end, switch to headA
            b = (b == null) ? headA : b.next;
        }

        // Either intersection node or null
        return a;
    }
}