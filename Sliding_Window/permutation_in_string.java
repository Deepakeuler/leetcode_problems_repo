class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m)return false;
        int l = 0;
        int r = 0;
        int k = n;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i<n; i++){
            char c = s1.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer>map = new HashMap<>();
        while(r<m){
            char ch = s2.charAt(r);
            
            if(k<r-l+1){
                char c = s2.charAt(l);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)map.remove(c);
                l++;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(hm.equals(map))return true;
            r++;
        }return false;
    }
}