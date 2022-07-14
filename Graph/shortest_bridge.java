class Solution {
    
    class Edge{
        int i;
        int j;
        Edge(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    void paintWith2(int [][]grid){
         int n = grid.length;
        int m = grid[0].length;
        int breakMe = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    
                    paint(grid,i,j);
                    return;
                }
            }
        }
        return;
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        paintWith2(grid);
        
        Queue<Edge>q = new LinkedList<>();
        int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int level = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    q.add(new Edge(i,j));
                }
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i<size; i++){
                Edge removed = q.remove();
                for(int j = 0; j<dir.length; j++){
                    int newX = removed.i+dir[j][0];
                    int newY = removed.j+dir[j][1];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                        if(grid[newX][newY] == 0){
                            grid[newX][newY] = 1;
                            q.add(new Edge(newX,newY));
                        }
                        if(grid[newX][newY] == 2)return level ;
                    }
                }
            }
            level++;
        }return -1;
    }
    
    void paint(int[][]grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0 || grid[i][j] == 2)return;
        if(grid[i][j] == 1){
            grid[i][j] = 2;
        }
        paint(grid,i+1,j);
        paint(grid,i-1,j);
        paint(grid,i,j+1);
        paint(grid,i,j-1);
    }
}