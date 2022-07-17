class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)return null;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode res = temp;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        while(head.next!=slow){
            head = head.next;
        }
        head.next = head.next.next;
        return temp.next;
    }
}