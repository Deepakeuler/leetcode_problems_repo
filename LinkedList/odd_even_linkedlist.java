class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode evenHead = new ListNode(0);
        ListNode even = evenHead;
        ListNode oddHead = new ListNode(0);
        ListNode odd = oddHead;
        int i = 0;
        while(head!=null){
            if(i%2==0){
                evenHead.next = head;
                evenHead = evenHead.next;
            }else{
                oddHead.next = head;
                oddHead = oddHead.next;
            }
            head = head.next;
            i++;
        }evenHead.next = odd.next;
        oddHead.next = null;
        return even.next;
    }
}