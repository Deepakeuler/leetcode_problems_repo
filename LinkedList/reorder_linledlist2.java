class Solution {
    public void reorderList(ListNode head) {
        ListNode middle = mid(head);
        ListNode reverse = rev(middle);
        ListNode head1 = head;
        ListNode head2 = reverse;
        ListNode pointer = new ListNode(0);
        int i = 0;
        while(head1!=null && head2!=null){
            if(i%2==0){
                pointer.next = head1;
                head1 = head1.next;
                pointer = pointer.next;
                
            }else{
                pointer.next = head2;
                head2 = head2.next;
                pointer = pointer.next;
            }
            i++;
        }
    }
    ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }return slow;
    }
    
    ListNode rev (ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }return prev;
    }
    
}