class Solution {
    HashSet<Integer>visited;
    public int findCircleNum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        
        HashMap<Integer,List<Integer>>graph = new HashMap<>();
        for(int i = 0; i<n; i++){
            graph.put(i,new ArrayList<Integer>());
        }
        
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                int u = i;
                int v = j;
                if(nums[i][j]==1){
                    graph.get(u).add(v);
                }
            }
        }
        
        int count = 0;
        visited = new HashSet<>();
        for(int i =0; i<n; i++){
            if(!visited.contains(i)){
                count++;
                dfs(graph,i);
            }
        }return count;
    n
    
    void dfs(HashMap<Integer,List<Integer>>graph, int src){
        if(visited.contains(src))return;
        visited.add(src);
        for(int x:graph.get(src)){
            dfs(graph,x);
        }
    }
}