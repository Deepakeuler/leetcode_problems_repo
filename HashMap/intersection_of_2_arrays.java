class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums1){
            set.add(x);
        }
        HashSet<Integer> intersection = new HashSet<>();
        for(int x:nums2){
            if(set.contains(x)){
                intersection.add(x);
            }
        }
        int[]res = new int[intersection.size()];
        int i = 0;
        for(int x :intersection){
            res[i] = x;
            i++;
        }return res;
    }
}