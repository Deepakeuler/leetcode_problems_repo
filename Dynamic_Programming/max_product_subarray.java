class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        int ans =dp[0][0];
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(nums[i],Math.max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]));
            dp[i][1] = Math.min(nums[i],Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]));
            ans = Math.max(ans,dp[i][0]);
        }
        return ans;
    }
}