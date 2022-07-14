class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int ans = 0;
        if(nums.length==1)return 0;
        int n = nums.length;
        if(n==2)return (nums[0]>nums[1])?0:1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(mid>0 && mid<n-1){
                if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                    return mid;
                }else if(nums[mid]>nums[mid+1]){
                    r = mid-1;
                }else l = mid+1;
            }
            if(mid==0 ){if(nums[mid]>nums[mid+1])return 0;else return 1;}
            if(mid==n-1){if(nums[mid]>nums[mid-1])return n-1;else return n-1;}
        }return -1;
    }
}