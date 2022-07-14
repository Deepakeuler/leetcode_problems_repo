class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>out = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        HashMap<Character,Integer>hm = new HashMap<>();
        for(int i = 0; i<m; i++){
            char c = p.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int k = p.length();
        int l = 0;
        int r = 0;
        HashMap<Character,Integer>map = new HashMap<>();
        while(r<n){
            
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            if(k<r-l+1){
                char left = s.charAt(l);
                map.put(left,map.get(left)-1);
                if(map.get(left)==0)map.remove(left);
                l++;
            }
            
                if(map.equals(hm))out.add(l);
            r++;
            
        }return out;
    }
}