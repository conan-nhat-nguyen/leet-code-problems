/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        // Move p2 n nodes ahead of p1
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }

        // Move p1 and p2 together until p2 reaches the end of the list
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // Remove the nth node from the end of the list
        p1.next = p1.next.next;

        return dummy.next;
    }
}