class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int res = helper(nums,k)-helper(nums,k-1);
        return res;
    }
    private int helper(int []nums,int k){
        int l = 0;
        int r = 0;
        int n = nums.length;    
        int res = 0;
        HashMap<Integer,Integer>hm = new HashMap<>();
        while(r<n){
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            
            while(hm.size()==k+1){
                int left = nums[l];
                hm.put(left,hm.get(left)-1);
                if(hm.get(left)==0)hm.remove(left);
                l++;
            }
            res+=r-l+1;
            r++;
        }return res;
    }
}