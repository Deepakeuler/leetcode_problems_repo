class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] arr = new int[nums.length];
        for(int i =0; i < nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = pq.remove();
        }
        return arr;
    }
}