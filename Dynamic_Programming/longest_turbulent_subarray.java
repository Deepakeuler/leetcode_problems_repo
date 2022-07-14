class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n == 0)return 0;
        if(n==1)return 1;
        int[][] dp = new int[n][2];
        int max = 0;
        for(int i = 1; i<n; i++){
            if(arr[i]<arr[i-1]){
                dp[i][0] = dp[i-1][1]+1;
                max = Math.max(max,dp[i][0]);
            }
            else if(arr[i]>arr[i-1]){
                dp[i][1] = dp[i-1][0]+1;
                max = Math.max(max,dp[i][1]);
            }
        }return max+1;
    }
}