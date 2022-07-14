class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int x = helper1(nums,target);
        int y = helper2(nums,target);
        int[]res = new int[2];
        res[0] = x;
        res[1] = y;
        return res;
    }
    private int helper1(int []nums,int target){
        int r = nums.length-1;
        int l = 0;
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                ans = mid;
                r= mid-1;
            }else if(nums[mid]>target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }return ans;
    }
    private int helper2(int[]nums,int target){
        int l = 0;
        int r = nums.length-1;
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                ans = mid;
                l = mid+1;
            }else if(nums[mid]>target){
                r= mid-1;
            }else{
                l = mid+1;
            }
        }return ans;
    }
}