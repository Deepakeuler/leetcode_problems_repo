class Solution {
    int res = 0;
    public int islandPerimeter(int[][] grid) {
       visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int ans = helper(i,j,grid);
                    return ans;
                }
            }
        }
        return -1;
    }
    
    boolean visited[][] ;
    int helper(int i, int j, int[][]grid){
        
        if(!isValid(i,j,grid))  return 0;
        if(visited[i][j]) return 0;
        visited[i][j] = true;
        int myVal = getNeighborsNumber(i,j,grid);
        int l = helper(i+1,j,grid);
        int r = helper(i,j-1,grid);
        int u = helper(i,j+1,grid);
        int d = helper(i-1,j,grid);
        return myVal + l + r + u + d;    
        
    }
    
    boolean isValid(int i, int j, int [][]grid){
        if( i < 0 || j< 0 || i>= grid.length || j>= grid[0].length || grid[i][j] != 1) return false;
        return true;
    }
    int getNeighborsNumber(int i, int j, int[][]grid){
        
        int perimeterCount = 0;
        if(i+1< 0 || i+1>= grid.length || j < 0 || j >= grid[0].length || grid[i+1][j] == 0)                        perimeterCount++;
        
        if(i< 0 || i>= grid.length || j+1 < 0 || j+1 >= grid[0].length || grid[i][j+1] == 0)                        perimeterCount++;
        
        if(i - 1< 0 || i - 1 >= grid.length || j < 0 || j >= grid[0].length || grid[i-1][j] == 0)                        perimeterCount++;
        
        if(i< 0 || i >= grid.length || j-1 < 0 || j-1 >= grid[0].length || grid[i][j-1] == 0)                        perimeterCount++;
        
        return perimeterCount;
        
        
    }
    
    
}