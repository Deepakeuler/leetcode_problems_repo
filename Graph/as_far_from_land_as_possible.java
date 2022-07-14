class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    int[][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int maxDistance(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        Queue<Pair>q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(nums[i][j] == 1){
                    q.add(new Pair(i,j));
                }
            }
        }
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i<size; i++){
                Pair removed = q.remove();
                for(int j = 0; j<dir.length; j++){
                    int newX = removed.i+dir[j][0];
                    int newY = removed.j+dir[j][1];
                    if(newX>=0 && newX<n && newY>=0 && newY<m && nums[newX][newY]==0){
                        q.add(new Pair(newX,newY));
                        nums[newX][newY]=level;
                    }
                }
            }
        }return (level==1)?-1:level-1;
    }
}