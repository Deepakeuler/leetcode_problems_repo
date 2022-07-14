class Solution {
    public int characterReplacement(String s, int k) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i<=26; i++){
            char ch = (char)('A'+i);
            int check = helper(s,k,ch);
            res = Math.max(check,res);
        }
        return res;
    }
    
    private int helper(String s,int k, char ch){
        
        int l = 0;
        int r = 0;
        int n = s.length();
        int diff = 0;
        int ans = 0;
        while(r<n){
            char c = s.charAt(r);
            if(c!=ch)diff++;
            while(diff>k){
                char c1 = s.charAt(l);
                if(c1!=ch)diff--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
            
        }return ans;
        
    }
}