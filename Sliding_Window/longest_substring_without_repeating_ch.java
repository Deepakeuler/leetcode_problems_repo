class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int r = 0;
        int l = 0;
        int n = s.length();
        if(n ==0)return 0;
        if(n ==1)return 1;
        int max = Integer.MIN_VALUE;
        while(r<n){
            char c = s.charAt(r);
            
            while(hm.containsKey(c)){
                char le = s.charAt(l);
                hm.put(le,hm.get(le)-1);
                if(hm.get(le) == 0)hm.remove(le);
                l++;
            }
                max = Math.max(r-l+1,max);
                hm.put(c,hm.getOrDefault(c,0)+1);
            r++;
        }return max;
    }
}