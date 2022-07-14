class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i= i;
            this.j = j;
        }
    }
   
    public int shortestPathBinaryMatrix(int[][] nums) {
         int[][]dir = {{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}};
        int n = nums.length;
        int m = nums[0].length;
        int min = Integer.MAX_VALUE;
        if(nums[0][0]==1 || nums[n-1][m-1]==1)return -1;
        if(nums[0][0] == 0 && n == 1 && m == 1) return 1;
        Queue<Pair> q = new LinkedList<>();
        Pair first = new Pair(0,0);
        q.add(first);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            res++;
            
            for(int i = 0; i<size; i++){
                Pair removed = q.remove();
                for(int j = 0; j<dir.length; j++){
                    int newX = removed.i + dir[j][0];
                    int newY = removed.j + dir[j][1];
                    //System.out.println(newX+","+newY);
                    if(newX == n-1 && newY == m - 1) return res+1;
                    if(newX>=0 && newY>=0 && newX<n && newY<m && nums[newX][newY] == 0){
                        nums[newX][newY] = 1;
                        q.add(new Pair(newX,newY));
                    }
                }
            }
        }
        return -1;
    }
}