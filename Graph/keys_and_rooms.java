class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[]visit = new boolean[rooms.size()];
        Stack<Integer>st = new Stack<>();
        st.push(0);
        visit[0] = true;
        
        while(!st.isEmpty()){
            int key = st.pop();
            for(int x : rooms.get(key)){
                if(visit[x]==false){
                    visit[x] = true;
                    st.push(x);
                }
            }
        }
        for(boolean c : visit){
            if(!c)return false;
        }return true;
    }
}