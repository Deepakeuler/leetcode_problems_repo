class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>set = new HashMap<>();
        for(int x:nums1){
            set.put(x,set.getOrDefault(x,0)+1);
        }
        List<Integer>list = new ArrayList<>();
        for(int x:nums2){
            if(set.containsKey(x)){
                set.put(x,set.get(x)-1);
                if(set.get(x)==0)set.remove(x);
                list.add(x);
            }
        }
        int[]arr = new int[list.size()];
        int i = 0;
        for(int x:list){
            arr[i] = x;
            i++;
        }return arr;
    }
}