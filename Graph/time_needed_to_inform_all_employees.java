class Solution {
    
    class Pair{
        int person;
        int time;
        Pair(int person, int time){
            this.person = person;
            this.time = time;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,List<Integer>>graph = new HashMap<>();
        Queue<Pair>q = new LinkedList<>();
        HashSet<Integer>visited = new HashSet<>();
        
        for(int i = 0; i<manager.length; i++){
            if(manager[i]==-1)continue;
            if(!graph.containsKey(manager[i]))
                graph.put(manager[i], new ArrayList<>());
            graph.get(manager[i]).add(i);
        }
        
        int headtime = informTime[headID];
        
        q.add(new Pair(headID,headtime));
        
        visited.add(headID);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Pair removed = q.remove();
                int employee = removed.person;
                int time = removed.time;
                if(!graph.containsKey(employee))continue;
                for(int subordinate : graph.get(employee)){
                    if(!visited.contains(subordinate)){
                        visited.add(subordinate);
                        q.add(new Pair(subordinate,time+informTime[subordinate]));
                    }
                }if(ans<time)ans = time;
            }
        }return ans;
    }
}