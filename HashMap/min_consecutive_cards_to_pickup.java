class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int r = 0;
        int l = 0;
        int ans = 0;
        int res = Integer.MAX_VALUE;
        HashMap<Integer,Integer>hm = new HashMap<>();
        
        while(r<n){
            
            int right = cards[r];
            hm.put(right,hm.getOrDefault(right,0)+1);
            while(hm.get(right)==2){
                ans = r-l+1;
                res = Math.min(res,ans);
                int left = cards[l];
                hm.put(left,hm.get(left)-1);
                if(hm.get(left)==0)hm.remove(left);
                l++;
            }
            r++;
        }
        return (res==Integer.MAX_VALUE)?-1:res;
    }
}