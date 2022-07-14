class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int r = 0;
        int l = 0;
        int size = nums.length;
        int[] nge = new int[size];
        int[]res = new int[size-k+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(size-1);
        nge[size-1] = size;
        for(int i = size-2; i>=0; i--){
            while(stack.size()>0 && nums[i]>=nums[stack.peek()]){
                stack.pop();
            }
            if(stack.size() == 0){
                nge[i] = size;
            }else{
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        int j = 0;
        for(int i=0;i<=nums.length-k;i++){
            if(j<i){
                j = i;
            }
            while(nge[j]<i+k){
                j=nge[j];
            }
            res[i]=nums[j];
        }
        return res;
    }
}