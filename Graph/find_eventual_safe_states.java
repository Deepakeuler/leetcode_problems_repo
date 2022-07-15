class Solution {
    public List<Integer> eventualSafeNodes(int[][] nums) {
        List<Set<Integer>>graph = new ArrayList<>();
        List<Set<Integer>>rgraph = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            graph.add(new HashSet<>());
            rgraph.add(new HashSet<>());
        }
        
        boolean[]safe = new boolean[nums.length];
        Queue<Integer>q = new LinkedList<>();
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i].length == 0)q.add(i);
            else{
                for(int j : nums[i]){
                    graph.get(i).add(j);
                    rgraph.get(j).add(i);
                }
            }
        }
        while(!q.isEmpty()){
            int j = q.remove();
            safe[j] = true;
            for(int i : rgraph.get(j)){
                graph.get(i).remove(j);
                if(graph.get(i).isEmpty())q.add(i);
            }
        }
        List<Integer>res = new ArrayList<>();
        for(int i = 0; i<safe.length; i++){
            if(safe[i])res.add(i);
        }return res;
    }
}