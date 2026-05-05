public class SortList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) return head;

        // 1. Find middle
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null; // break list

        // 2. Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3. Merge sorted halves
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // important for split

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        // Attach remaining
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }

    // Helper to print list
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SortList obj = new SortList();

        // Example: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        head = obj.sortList(head);

        obj.printList(head);
        // Output: 1 -> 2 -> 3 -> 4 -> null
    }
}