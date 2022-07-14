class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = fruits.length;
        int k = 2;
        if(n == 0)return 0;
        if(n == 1)return 1;
        int res = 0;
        while(r<n){
            int right = fruits[r];
            hm.put(right,hm.getOrDefault(right,0)+1);
            while(hm.size()>k){
                int left = fruits[l];
                hm.put(left,hm.get(left)-1);
                if(hm.get(left)==0)hm.remove(left);
                l++;
            }
            res = Math.max(res,r-l+1);
            
            r++;
        }return res;
    }
}