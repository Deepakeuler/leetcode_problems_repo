class Solution {
    int res = 0;
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    if(i == 0 || i == n-1 || j == 0 || j == m-1){
                        paint(i,j,grid);
                    }
                }
            }
        }
        for(int i = 1; i<n-1; i++){
            for(int j = 1; j<m-1; j++){
                if(grid[i][j] == 1){
                    count(i,j,grid);
                }
            }
        }return res;
    }
    void paint(int i, int j, int[][]grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1)return;
        grid[i][j] = 0;
        paint(i+1,j,grid);
        paint(i-1,j,grid);
        paint(i,j-1,grid);
        paint(i,j+1,grid);
    }
    void count(int i, int j, int[][]grid){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]!=1)return;
        if(grid[i][j]==1){
            res++;
            grid[i][j] = 0;
        }
        count(i+1,j,grid);
        count(i-1,j,grid);
        count(i,j+1,grid);
        count(i,j-1,grid);
    }
}