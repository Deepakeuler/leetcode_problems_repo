class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode cur = head;
        while(left>1){
            prev = curr;
            curr = curr.next;
            l--;
            r--;
        }
        ListNode connection = prev;
        ListNode tail = curr;
        ListNode third = null;
        while(right >0){
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            r--;
        }
    }
}