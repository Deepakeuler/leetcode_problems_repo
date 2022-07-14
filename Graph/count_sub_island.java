class Solution {
    int ans = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        int n = grid1.length;
        int m = grid1[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0;j<m; j++){
                if(grid2[i][j]==1){
                    ans = 1;
                    helper(i,j,grid1,grid2);
                    res+=ans;
                }
            }
        }return res;
    }
    
    void helper(int i, int j, int[][]grid1, int[][]grid2){
        
        if(i<0 || i>=grid1.length || j<0 || j>=grid1[0].length || grid2[i][j]==0)return ;
        if(grid1[i][j] == 0)ans = 0;
        grid2[i][j] = 0;
        helper(i+1,j,grid1,grid2);
        helper(i-1,j,grid1,grid2);
        helper(i,j+1,grid1,grid2);
        helper(i,j-1,grid1,grid2);
    }
}