/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head node for the result linked list
        ListNode dummyHead = new ListNode(0);
        // Create a pointer to the current node in the result linked list
        ListNode curr = dummyHead;
        // Initialize the carry variable to 0
        int carry = 0;
        // Loop through both input linked lists until both are null
        while (l1 != null || l2 != null) {
            // Get the value of the current node in each input list, or 0 if the list is null
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            // Calculate the sum of the current nodes, plus any carry from the previous iteration
            int sum = carry + x + y;
            // Update the carry variable for the next iteration
            carry = sum / 10;
            // Add a new node to the result linked list with the sum modulo 10 (to get the rightmost digit)
            curr.next = new ListNode(sum % 10);
            // Move the current pointer to the next node in the result linked list
            curr = curr.next;
            // Move the input list pointers to the next node, or null if the list is already at the end
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // If there is a carry after the last iteration, add a new node with that value to the result linked list
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        // Return the result linked list, skipping the dummy head node
        return dummyHead.next;
    }
}