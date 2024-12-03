// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy head for the result list
        ListNode current = dummyHead; // Pointer to build the result list
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Compute the sum and carry
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to the next nodes in the lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Handle the final carry
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // Return the next node to skip the dummy head
    }

    // Helper method to print a linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // Create first number: 342 (stored as 2 -> 4 -> 3)
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        // Create second number: 465 (stored as 5 -> 6 -> 4)
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        // Compute the sum
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result: 807 (stored as 7 -> 0 -> 8)
        System.out.print("Result: ");
        printList(result);
    }
}
