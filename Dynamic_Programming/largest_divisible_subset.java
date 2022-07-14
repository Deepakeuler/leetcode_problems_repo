class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int [] dp = new int[n];
        int pre[] = new int[n];
        List<Integer> list = new ArrayList<>();
        dp[0]=1;
        int max = 0;
         int index = -1;
        for(int i = 0; i <n; i++){
            dp[i] = 1;
            pre[i] = -1;
            for(int j = i-1; j>=0;j--){
                if(nums[i]%nums[j] == 0){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        pre[i] = j;
                    }
                }
            }
            if(dp[i]>max){
                max = dp[i];
                index = i;
            }
            
        }
        while(index!=-1){
            list.add(nums[index]);
            index = pre[index];
        }
        
        
        return list;
    }
}