public class DeleteNodeInALinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to delete given node (no head given)
    public void deleteNode(ListNode node) {
        // Copy next node's value
        node.val = node.next.val;

        // Skip next node
        node.next = node.next.next;
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
        DeleteNodeInALinkedList obj = new DeleteNodeInALinkedList();

        // Create list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Suppose we want to delete node with value 5
        ListNode nodeToDelete = head.next;

        obj.deleteNode(nodeToDelete);

        obj.printList(head);
        // Output: 4 -> 1 -> 9 -> null
    }
}