class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while(current!=null){
            list.add(current.val);
            current = current.next;
        }
        
        
        Stack<Integer> stack = new Stack<>();
        int[] out = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            while(!stack.isEmpty() && list.get(stack.peek())<list.get(i)){
                out[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }return out;
    }
}