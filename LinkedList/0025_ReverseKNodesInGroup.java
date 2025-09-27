
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // count length
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int rot = len / k;
        ListNode cur = head;
        ListNode prev = null;
        ListNode nextNode = null;

        // this will be the head we return
        ListNode newHead = null;
        // this will track the tail of the last reversed group
        ListNode lastTail = null;

        while (rot > 0) {
            int temp_k = k;
            temp = cur; // temp is start of this group (will become tail)

            // reverse k nodes
            while (temp_k > 0) {
                nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
                temp_k--;
            }

            // set newHead once (after first group reversed)
            if (newHead == null) {
                newHead = prev;
            }

            // connect previous group tail to current reversed head
            if (lastTail != null) {
                lastTail.next = prev;
            }

            // update lastTail (current group's tail is 'temp')
            lastTail = temp;

            // reset prev for the next group
            prev = null;

            rot--;
        }

        // connect leftover nodes (not reversed) to the end
        if (lastTail != null) {
            lastTail.next = cur;
        }

        return newHead;
    }
}
