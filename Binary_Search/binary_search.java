class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int n = nums.length;
        int r = n-1;
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                ans = mid;
                return ans;
            }
            else if(nums[mid]>target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }return ans;
    }
}