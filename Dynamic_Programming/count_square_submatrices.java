class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [] [] dp = new int [m][n];
        int ans = 0;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                //last cell
                if(i == m-1 && j == n-1){
                    dp[i][j] = matrix[i][j];
                }
                //last row
                else if(i==m-1){
                    dp[i][j]=matrix[i][j];
                }
                //last column
                else if(j==n-1){
                    dp[i][j]=matrix[i][j];
                    
                }//zeros
                else if(matrix[i][j]==0){
                    dp[i][j]=matrix[i][j];
                }else{
                    //ones
                    int toAdd = 0;
                    int min = Math.min(dp[i+1][j],dp[i+1][j+1]);
                    min = Math.min(min,dp[i][j+1]);
                    toAdd = min+1;
                    dp[i][j] = toAdd;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
    
}