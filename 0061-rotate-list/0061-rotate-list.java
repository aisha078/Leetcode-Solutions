class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode curr = head;
        int len = 1;

        while (curr.next != null) {
            curr = curr.next;
            len++;
        }

        curr.next = head;
        k %= len;

        int steps = len - k;
        curr = head;

        for (int i = 1; i < steps; i++)
            curr = curr.next;

        ListNode newHead = curr.next;
        curr.next = null;

        return newHead;
    }
}