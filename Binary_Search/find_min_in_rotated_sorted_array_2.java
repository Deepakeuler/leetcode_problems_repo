class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int n = nums.length;
        if(n == 0)return -1;
        if(n == 1)return nums[0];
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[r]){
                l = mid+1;
            } else if(nums[mid]<nums[r]){r = mid;}
            else r--;
        }return nums[l];
    }
}