public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null)return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)break;
        }
        if(fast == null || fast.next == null)return null;
        while(slow!=head){
            head = head.next;
            slow = slow.next;
        }return slow;
    }
}