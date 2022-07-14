class Solution {
    
    class Edge{
        int i;
        int j;
        Edge(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    int[][] paint(char[][]maze){
        int n = maze.length;
        int m = maze[0].length;
        int[][] nums = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(maze[i][j] == '.')nums[i][j] = 0;
                if(maze[i][j] == '+')nums[i][j] = 1;
            }
        }return nums;
    }
    
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int n = maze.length;
        int m = maze[0].length;
        
        int[][] nums = paint(maze);
        
        HashSet<List<Integer>>visited = new HashSet<>();
        
        List<Integer>v = new ArrayList<>();
        
        v.add(entrance[0]);
        v.add(entrance[1]);
        
        visited.add(v);
        
        int level = 0;
        Queue<Edge>q = new LinkedList<>();
        q.add(new Edge(entrance[0],entrance[1]));
        int[][]dir = {{-1,0},{1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0;i <size; i++){
                Edge removed = q.remove();
                for(int j = 0; j<dir.length; j++){
                    List<Integer> nextVisit = new ArrayList<>();
                    int newX = removed.i + dir[j][0];
                    int newY = removed.j + dir[j][1];
                    nextVisit.add(newX);
                    nextVisit.add(newY);
                    
                    if(inBounds(newX,newY,n,m)){
                        if(nums[newX][newY] == 0){
                            if(!visited.contains(nextVisit)){
                                visited.add(nextVisit);
                                q.add(new Edge(newX,newY));
                                if(destination(newX,newY,n,m))return level;
                            }
                        }
                    }
                }
            }
        }return -1;
    }
    boolean inBounds(int x, int y, int n, int m){
        if(x>=0 && x<n && y >=0 && y<m)return true;
        return false;
    }
    boolean destination(int x, int y, int n, int m){
        if(x == 0 || x == n-1 || y == 0 || y == m-1)return true;
        return false;
    }
}