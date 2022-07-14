class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
               if(grid[i][j] == 0){
                   if(i == 0 || i == n-1 || j == 0 || j==m-1){
                       paint(i,j,grid);
                   }
               } 
            }
        }
        int res = 0;
        for(int i =1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(grid[i][j] == 0){
                    res++;
                    count(i,j,grid);
                }
            }
        }return res;
    }
    void paint(int i, int j, int[][]grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=0)return;
        grid[i][j] = 1;
        paint(i+1,j,grid);
        paint(i-1,j,grid);
        paint(i,j-1,grid);
        paint(i,j+1,grid);
    }
    void count(int i, int j, int[][]grid){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]!=0)return;
        grid[i][j] = 1;
        count(i+1,j,grid);
        count(i-1,j,grid);
        count(i,j+1,grid);
        count(i,j-1,grid);
    }
}