class Solution {
    class Pair{
        int val;
        int freq;
        Pair(){};
        Pair(int val,int freq){
            this.val = val;
            this.freq = freq;
        }
        
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[]res = new int[k];
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i = 0 ;i < nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.freq-b.freq);
        
        for(int key : hm.keySet()){
            Pair p = new Pair(key,hm.get(key));
            if(pq.size()<k){
                pq.add(p);
            }
            else{
                Pair curr = pq.peek();
                if(p.freq>curr.freq){
                    pq.remove(curr);
                    pq.add(p);
                }
            }
        }
        
        for(int i = 0; i < res.length; i++){
            res[i] = pq.remove().val;
        }return res;
    }
}