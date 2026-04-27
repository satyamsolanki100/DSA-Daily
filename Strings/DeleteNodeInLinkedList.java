class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        // Copy next node value into current node
        node.val = node.next.val;

        // Skip the next node
        node.next = node.next.next;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DeleteNodeInLinkedList obj = new DeleteNodeInLinkedList();

        // Create list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.print("Before: ");
        printList(head);

        // Delete node with value 5 (we pass reference)
        obj.deleteNode(head.next);

        System.out.print("After: ");
        printList(head);
    }
}