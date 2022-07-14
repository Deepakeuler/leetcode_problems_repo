class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = tasks.length;
        if(n == 0 || n == 1)return -1;
        for(int i = 0; i<n; i++){
            hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
        }
        int ans = 0;
        int task = 0;
        for(int k:hm.keySet()){
            int x = hm.get(k);
            if(x == 1){
                ans = -1;
            }else{
                while(x>0){
                    task++;
                    x = x-3;
                }
            }
        }return (ans == -1)?-1:task;
    }
}