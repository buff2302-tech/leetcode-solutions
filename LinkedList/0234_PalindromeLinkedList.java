
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null  && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println("mid prev "+ slow.val);
        // System.out.println("mid "+ slow.next.val);
        ListNode curr = slow.next;
        ListNode next = null;
        ListNode prev = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode temp2 = prev; // reversed half part starting node
        ListNode temp = head; // original ll starting
        while(temp2!=null){
            if(temp.val!=temp2.val)return false;
            temp = temp.next;
            temp2 = temp2.next;
        }

        
        return true;

    }
}
