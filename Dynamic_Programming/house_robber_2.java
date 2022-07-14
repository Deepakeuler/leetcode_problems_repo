class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)return 0;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int[]dp = new int[n];
        int []dp2 = new int[n];
        dp2[0]=0;
        dp2[1]=nums[1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i <n; i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
            dp2[i] = Math.max(dp2[i-1],nums[i]+dp2[i-2]);
        }return Math.max(dp[n-2],dp2[n-1]);
    }
}