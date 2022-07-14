class Solution {
    class Pair{
        char s;
        int freq;
        Pair(){};
        Pair(char s, int freq){
            this.s = s;
            this.freq = freq;
        }
        
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        
        for(char c : hm.keySet()){
            Pair p = new Pair();
            p.s = c;
            p.freq = hm.get(c);
            pq.add(p);
        }
        
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            Pair removed = pq.remove();
            char c = removed.s;
            int freq = removed.freq;
            while(freq != 0){
                ans = ans.append(c);//""+c;
                freq--;
            }
        }
        return ans.toString();
    }
    
}