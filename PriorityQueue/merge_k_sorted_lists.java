class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode temp = new ListNode(0);
        ListNode out = temp;
        for(ListNode x:lists){
            while(x!=null){
                pq.add(x);
                x = x.next;
            }
        }
        while(!pq.isEmpty()){
            temp.next = pq.remove();
            temp = temp.next;
        }temp.next = null;
        return out.next;
    }
}