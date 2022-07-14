class Solution {
    public boolean canPartition(int[] nums) {
        int n =nums.length;
        int sum = 0;
        for(int x:nums){
            sum += x;
        }
        if(sum%2!=0)return false;
        int half = sum/2;
        Boolean [][] dp = new Boolean[n+1][half+1];
        for(int i =0; i<=n; i++){
            for(int j =0; j<=half; j++){
                if(i ==0 && j == 0)dp[i][j] = true;
                else if(j == 0)dp[i][j] = true;
            }
        }
        boolean res = helper(nums,half,dp,n);
        return res;
    }
    
    boolean helper(int[]nums,int half,Boolean[][]dp,int n){
        if(half == 0) return true;
        if(n == 0) return false;
        if(n==0 && half ==0)return true;
        
        if(dp[n][half] != null)return dp[n][half];
        if(nums[n-1]<=half){
            
            dp[n][half] = helper(nums,half-nums[n-1],dp,n-1) || helper(nums, half,dp,n-1);
            
        }
        else{
            dp[n][half] = helper(nums,half,dp,n-1);
        }
        return dp[n][half];
    }
    
}