class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int r = 0;
        int l = 0;
        int ans = 0;
        if(k<=1)return 0;
        int prd = 1;
        while(r<n){
            prd*=nums[r];
            while(prd>=k){
                prd/=nums[l];
                l++;
            }
            ans += r-l+1;
            r++;
        }return ans;
    }
}