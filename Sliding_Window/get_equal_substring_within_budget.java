class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int r = 0;
        int l = 0;
        int n = s.length();
        int res = 0;
        int cost = 0;
        while(r<n){
            char c = s.charAt(r);
            cost+=Math.abs(c-t.charAt(r));
            while(cost>maxCost){
                char ch = s.charAt(l);
                cost-= Math.abs(ch-t.charAt(l));
                l++;
            }
            res = Math.max(res,r-l+1);
            r++;
        }return res;
    }
}