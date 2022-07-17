class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode res1 = temp;
        head = head.next;
        while(head!=null){
            int res = 0;
            while(head.val!=0){
                res+=head.val;
                head= head.next;
            }
            head = head.next;
            temp.next = new ListNode(res);
            temp = temp.next;
        }temp.next = null;
        return res1.next;
    }
}