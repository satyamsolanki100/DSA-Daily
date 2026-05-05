public class OddEvenLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode odd = head;            // 1st node
        ListNode even = head.next;      // 2nd node
        ListNode evenHead = even;       // store even head

        // Rearrange nodes
        while (even != null && even.next != null) {
            odd.next = even.next;       // link odd nodes
            odd = odd.next;

            even.next = odd.next;       // link even nodes
            even = even.next;
        }

        // Connect odd list with even list
        odd.next = evenHead;

        return head;
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
        OddEvenLinkedList obj = new OddEvenLinkedList();

        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = obj.oddEvenList(head);

        obj.printList(head);
        // Output: 1 -> 3 -> 5 -> 2 -> 4 -> null
    }
}