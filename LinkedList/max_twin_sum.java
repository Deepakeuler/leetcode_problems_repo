class Solution {
    public int pairSum(ListNode head) {
        if(head == null)return 0;
        if(head.next == null)return head.val;
        int max = Integer.MIN_VALUE;
        ListNode middle = mid(head);
        ListNode reverse = rev(middle);
        while(reverse!=null){
            max = Math.max(head.val+reverse.val,max);
            reverse = reverse.next;
            head = head.next;
        }return max;
    }
    
    private ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }return slow;
    }
    private ListNode rev(ListNode head){
        ListNode temp = null;
        while(head!=null){
            ListNode next = head.next;
            head.next= temp;
            temp = head;
            head = next;
        }return temp;
    }
}max_twin_sum.java
