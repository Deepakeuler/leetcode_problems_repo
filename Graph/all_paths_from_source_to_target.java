class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        helper(graph,0,graph.length-1,new ArrayList<>());
        return res;
    }
    
    void helper(int[][]graph, int src, int dst, List<Integer>psf){
        psf.add(src);
        if(src == dst)res.add(new ArrayList(psf));
        else{
            for(int x : graph[src]){
                helper(graph,x,dst,psf);
                psf.remove(psf.size()-1);
            }
        }
    }
}