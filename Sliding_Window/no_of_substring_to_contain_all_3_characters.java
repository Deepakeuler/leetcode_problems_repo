class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        int r = 0, l= 0, n = s.length(), sum = 0, k = 3;
        
        while(r < n){
            char right = s.charAt(r);
            map.put(right, map.getOrDefault(right,0)+1);
            while(map.size() == 3){
                sum += (n - r );
                char left = s.charAt(l);
                map.put(left, map.get(left) -1 );
                if(map.get(left) == 0) map.remove(left);
                l++;
            }
            
            r++;
            
        }
        return sum;
    }no_of_substring_to_contain_all_3_characters.java
}