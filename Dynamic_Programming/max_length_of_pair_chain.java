class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if(n==0)return 0;
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1; i <n ;i++){
            for(int j = i-1; j>=0; j--){
                if(pairs [i][0]>pairs[j][1]){
                    dp[i] = Math.max(1+dp[j],dp[i]);
                }
            }
        }
        int res = 0;
        for(int x:dp){
            res = Math.max(res,x);
        }return res;
    }
}