class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int res = 0;
        int sum =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(r<n){
            int right = nums[r];
            
            while(hm.containsKey(nums[r])){
                sum = sum-nums[l];
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0)hm.remove(nums[l]);
                l++;
            }
            sum +=nums[r];
            res = Math.max(sum,res);
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            r++;
            
        }return res;
    }
}