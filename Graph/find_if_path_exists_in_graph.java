class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)return true;
        HashMap<Integer,List<Integer>>graph = new HashMap<>();
        for(int i = 0; i<n; i++){
            graph.put(i,new ArrayList<Integer>());
        }
        
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        HashSet<Integer>set = new HashSet<>();
        boolean res = hasPath(graph,set,source,destination);
        set.add(source);
        if(!res)return false;
        return true;
    }
    
    boolean hasPath(HashMap<Integer,List<Integer>>graph, HashSet<Integer>set,int source,int destination){
        if(source == destination)return true;
        for(int x:graph.get(source)){
            if(x == destination)return true;
            if(set.contains(x))continue;
            set.add(x);
            boolean res = hasPath(graph,set,x,destination);
            if(res)return true;
        }return false;
    }
    
}