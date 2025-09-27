
class Solution {
    public Node flatten(Node head) {
        if( head == null) 
            return head;
	
        Node p = head;
        while(p!=null){
            
            if(p.child==null){
                p = p.next;
                continue;
            }
    
            Node temp = p.child;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = p.next; // conencting the next node with tail node of child - next

            
            p.next.prev = temp; // conencting the next node with tail node of child - prev
            p.next = p.child; 
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
