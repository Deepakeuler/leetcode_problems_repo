class Solution {
    
    public int makeConnected(int n, int[][] nums) {
        if(nums.length < n-1) return -1;
        
        HashMap<Integer,List<Integer>>graph = new HashMap<>();
        for(int i = 0; i< n ; i++){
            graph.put(i,new ArrayList<Integer>());
        }
        
        for(int i = 0; i<nums.length; i++){
            int u = nums[i][0];
            int v = nums[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        HashSet<Integer>visited = new HashSet<>();
        
        int island = 0;
        
        for(int node = 0; node < n; node++){
            int source = node;
            if(!visited.contains(source)){
                island++;
                dfs(graph,source, visited);
            }
        }
        
        return island - 1;
    }
    
    void dfs(HashMap<Integer,List<Integer>>graph, int src, HashSet<Integer>visited){
        if(visited.contains(src))return;
        visited.add(src);
        if(!graph.containsKey(src)) return;
        for(int x : graph.get(src)){
            if(visited.contains(x))continue;
            dfs(graph,x, visited);
        }
        return;
    }
}