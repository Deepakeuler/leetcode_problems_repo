class Solution {
    public int uniquePaths(int m, int n) {
        int i = m-1;
        int j = n-1;
        int [][] dp = new int[m][n];
        
        for(int r = 0; r<m; r++){
            for(int k = 0; k <n; k++){
                if(r == 0 || k == 0){
                    dp[r][k] = 1;
                }else{
                    dp[r][k] = dp[r-1][k]+dp[r][k-1];
                }
            }
        }return dp[i][j];
    }
}