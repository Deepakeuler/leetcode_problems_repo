class Solution {

    public int maximalSquare(char[][] input) {
        int n = input.length;
        int m = input[0].length;
        int[][] dp = new int[n][m];
        int res = helper(input,dp,n,m);
        return res;
    }
    
    private int helper(char[][]input, int[][]dp, int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == n-1) dp[i][j] = (input[i][j] == '1') ? 1 : 0;
                if(j == m-1) dp[i][j] = (input[i][j] == '1') ? 1 : 0;
            }
        }
        
        for(int i =n-2; i>=0; i--){
            for(int j = m-2; j>=0; j--){
                if(input[i][j] == '0') continue;
                dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j],dp[i][j+1]))+1;
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0;i <n; i++){
            for(int j = 0; j<m; j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        
        return max*max;
    }
    

}
