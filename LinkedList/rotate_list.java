class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0)return head;
        if( head == null || head.next == null )return head;
        int i = 0;
        int size = 1;
        ListNode n = new ListNode(0);
        n  = head;
        while(n.next.next!=null){
                size++;
                n=n.next;
            }size++;
            k = k %size;
        while(i<k){
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next.next!=null){
                fast=fast.next;
            }
            ListNode res = fast.next;
            fast.next.next = slow;
            fast.next = null;
            head = res;
            i++;
        }
    return head;
    }
}