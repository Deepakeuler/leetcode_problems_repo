class KthLargest {
PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int x:nums){
            pq.add(x);
        }
        while(pq.size()>k){
            pq.remove();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k){
            pq.remove();
        }return pq.peek();
    }
}
