class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int amt = 1; amt < dp.length; amt++){
            for(int coin:nums){
                if(coin<=amt){
                    int ramt = amt-coin;
                    dp[amt] += dp[ramt];
                }
            }
        }return dp[target];
    }
}