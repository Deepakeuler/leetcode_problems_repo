class Solution {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode res = new ListNode(0);
        ListNode out = res;
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        int i =0;
        int size = list.size();
        while(i!=size){
            res.next = new ListNode(list.get(i));
            res = res.next;
            i++;
        }return out.next;
    }
}