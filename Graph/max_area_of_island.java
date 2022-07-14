class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int res = helper(i,j,grid);
                max = Math.max(res,max);
            }
        }return max;
    }
    int helper(int i, int j, int[][]grid){
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1)return 0;
        
        if(grid[i][j] == 1){
            grid[i][j] = 0;
        }
        
        int a = helper(i+1,j,grid);
        int b = helper(i-1,j,grid);
        int c = helper(i,j+1,grid);
        int d = helper(i,j-1,grid);
        return a+b+c+d+1;
    }
}