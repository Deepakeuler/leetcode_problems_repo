class Solution {
    public int maxSubArray(int[] nums) {
        int minSumSoFar = nums[0];
        int result = nums[0];
        int sumSoFar = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            sumSoFar+=nums[i];
            result = Math.max(result, sumSoFar);
            result = Math.max(result, sumSoFar - minSumSoFar);
            minSumSoFar = Math.min(minSumSoFar, sumSoFar);
        }
        return result; 
    }
}