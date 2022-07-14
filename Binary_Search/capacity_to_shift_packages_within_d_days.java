class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int r = 0;
        int l = 0;
        int res = -1;
        for(int i = 0; i<n; i++){
            r+=weights[i];
            l = Math.max(l,weights[i]);
        }
        while(l<=r){
            int mid = l+(r-l)/2;
            if(helper(mid,r,l,weights,days)){
                res = mid;
                r = mid-1;
            }else l = mid+1;
        }return res;
    }
    private boolean helper(int mid,int r,int l,int[]weights,int days){
        int d = 1;
        int m = 0;
        for(int i = 0; i<weights.length; i++){
            m+=weights[i];
            if(m>mid){
                d++;
                m = weights[i];
            }
            if(d >days)return false;
        }return true;
    }
}