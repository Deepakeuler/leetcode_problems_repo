class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[]lis = new int[n];
        int[]lds = new int[n];
        for(int i = 0; i<n; i++){
            lis[i] = 1;
            lds[i] = 1;
        }
        for(int i = 1; i<n; i++){
            for(int j = i-1; j>=0; j--){
                if(nums[i]>nums[j]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }
        for(int i = n-2; i>=0; i--){
            for(int j = i+1; j<n; j++){
                if(nums[i]>nums[j]){
                    lds[i] = Math.max(lds[i],lds[j]+1);
                }
            }
        }
        int res = 0;
        for(int i = 0; i<n; i++){
            if(hasLeft(nums,i)&&hasRight(nums,i)){
                res = Math.max(res,lds[i]+lis[i]-1);
            }
        }return n-res;
    }
    boolean hasLeft(int[]nums,int i){
        for(int j = 0; j<i; j++){
            if(nums[j]<nums[i])return true;
        }return false;
    }
    boolean hasRight(int []nums, int i){
        for(int j = i+1; j<nums.length;j++){
            if(nums[j]<nums[i])return true;
        }return false;
    }
}