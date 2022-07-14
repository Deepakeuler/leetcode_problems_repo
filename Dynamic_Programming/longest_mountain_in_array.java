class Solution {
    public int longestMountain(int[] nums) {
        int n = nums.length;
        if(n<3)return 0;
        int[]lis = new int[n];
        int[]lds = new int[n];
        for(int i = 0; i<n; i++){
            lis[i] = 1;
            lds[i] = 1;
        }
        for(int i = 1; i<n; i++){
            if(nums[i]>nums[i-1]){
                lis[i] = lis[i-1]+1;
            }
        }
        for(int i = n-2; i>=0; i--){
            if(nums[i]>nums[i+1]){
                lds[i] = lds[i+1]+1;
            }
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            if(hasLeft(nums,i,n)&&hasRight(nums,i,n)){
                max = Math.max(max,lds[i]+lis[i]-1);
            }
        }return max;
    }
    
    private boolean hasLeft(int[]nums,int top,int n){
        for(int i = top-1; i>=0; i--){
            if(nums[i] == nums[top])return false;
            else if(nums[i]<nums[top])return true;
        }return false;
    }
    
    private boolean hasRight(int[]nums,int top,int n){
        for(int i =top+1; i<n; i++){
            if(nums[i] == nums[top])return false;
            else if(nums[i]<nums[top])return true;
        }return false;
    }
}