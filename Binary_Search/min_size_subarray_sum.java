class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        if(n == 0)return 0;
        if(target == 0)return 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while(r<n){
            
            sum += nums[r];
            while(sum>=target){
                res = Math.min(res,r-l+1);
                sum = sum-nums[l];
                l++;
            }
            r++;
        }return (res==Integer.MAX_VALUE)?0:res;
    }
}