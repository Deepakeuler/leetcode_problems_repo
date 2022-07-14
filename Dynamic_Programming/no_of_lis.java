class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp,1);
        int count = 0;
        int res = 0;
        for(int i = 0; i<n; i++){
            cnt[i] = 1;
            for(int j = i-1; j>=0; j--){
                if(nums[i]>nums[j]){
                    if(dp[i] == dp[j]+1){
                       cnt[i] += cnt[j]; 
                    }
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(count == dp[i])res+=cnt[i];
            if(count < dp[i]){
                count = dp[i];
                res = cnt[i];
            }
        }
        return res;
    }
}