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
    public ListNode deleteDuplicates(ListNode head) {

        // Dummy node to handle deletion at the beginning
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Duplicate found
            if (curr.next != null && curr.val == curr.next.val) {

                int duplicateValue = curr.val;

                // Skip all nodes having duplicateValue
                while (curr != null && curr.val == duplicateValue) {
                    curr = curr.next;
                }

                // Connect previous unique node to next different node
                prev.next = curr;

            } else {

                // Current node is unique
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}