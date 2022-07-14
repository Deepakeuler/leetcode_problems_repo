class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int max = 0;
        for(int x:nums){
            max = Math.max(max,x);
        }
        int[] cnt = new int[max+1];
        int[] dp = new int[max+1];
        for(int i = 0; i<nums.length; i++){
            cnt[nums[i]] += nums[i];
        }
        dp[1] = cnt[1];
        dp[2] = Math.max(cnt[1],cnt[2]);
        for(int i = 3; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1],cnt[i]+dp[i-2]);
        }
        return Math.max(dp[max],dp[max-1]);
    }
}