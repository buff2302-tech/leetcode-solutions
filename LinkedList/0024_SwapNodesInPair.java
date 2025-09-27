
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode temp = head;
        int left;
        int right;
        while(temp != null && temp.next != null)
        {
            left = temp.val;
            right = temp.next.val;
            temp.val = right;
            temp.next.val = left;
            temp = temp.next.next;

        }
        return head;
    }
}
