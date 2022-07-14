class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        int r = 0;
        int l = 0;
        int size = s.length();
        String ans = "";
        int mc = 0;
        int size1 = t.length();
        int dmc = size1;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            // here we acquire the count, all valid answers
            while(r<size && mc < dmc){
                char c = s.charAt(r);
                hm.put(c,hm.getOrDefault(c,0)+1);
                if(hm.getOrDefault(c,0)<=map.getOrDefault(c,0)){// = because ahteracquiring it becomes equal
                    // so we add that too int mc
                    mc++;
                } 
                r++;
                f1 = true;
            }
            // first we'll start collecting answer and then
            // here we'll start deleting left which doesnt compute to the answer
            while(l<r && mc == dmc){
                String possibleAnswer = s.substring(l,r);
                if(ans.length() == 0 || possibleAnswer.length() < ans.length()){
                    ans = possibleAnswer;
                }
                char ch = s.charAt(l);
                l++;
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch)==0)hm.remove(ch);
                if(hm.getOrDefault(ch,0) < map.getOrDefault(ch,0)) mc--;
                f2 = true;
            }
            if(f1 == false && f2 == false)break;
        }return ans;
    }
}