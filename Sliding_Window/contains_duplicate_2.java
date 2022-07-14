class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)return false;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int l = 0; int r = 0;
        int n = nums.length;
        while(r<n){
            if(hm.containsKey(nums[r]) && r - l <= k) return true;
            while(r - l + 1 > k){
                int left = nums[l];
                hm.put(left, hm.get(left) - 1);
                if(hm.get(left) == 0) hm.remove(left);
                l++;
                
            }

            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            
            r++;
        }return false;
    }
}