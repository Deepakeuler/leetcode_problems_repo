class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int r = n-1;
        int l = 0;
        
        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(nums[mid]==target)return mid;
            if(nums[mid]>=nums[l]){
                if(nums[l]<=target && nums[mid]>target)r = mid-1;
                else l = mid+1;
            }
            else{
                if(nums[mid]<target && nums[r]>=target)l = mid+1;
                else r = mid-1;
            }
        }return -1;
    }
}