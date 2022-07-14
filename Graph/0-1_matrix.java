class Solution {
    
    class Pair {
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length; int n = mat[0].length;
        int [][]ans = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) q.offer(new Pair(i,j));
                ans[i][j] = 0;
            }
        }
        int level = 0;
        int dirs[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            
            int size = q.size();
            level++;
            for(int s = 0; s < size; s++){
                
                Pair pop = q.poll();
            
                for(int i = 0; i < dirs.length; i++){
                    int newX = pop.x + dirs[i][0];
                    int newY = pop.y + dirs[i][1];
                    if(inBounds(newX,newY, mat)){
                        mat[newX][newY] = 0;
                        ans[newX][newY] = level;
                    //    System.out.println(level);
                        q.offer(new Pair(newX, newY));
                    }
                }

                
            }
            
                        
        }
        
        return ans;
        
    }
    
    public boolean inBounds(int x, int y, int [][]mat){
        if(x >= 0 && y >= 0 && x < mat.length && y < mat[0].length && mat[x][y] == 1) return true;
        else return false;
    }
}