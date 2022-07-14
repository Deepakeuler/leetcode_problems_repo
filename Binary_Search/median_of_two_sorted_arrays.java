class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        
        int r = x;
        int l = 0;
        
        while(l<=r){
            int partitionX = l+(r-l)/2;
            int partitionY = (x+y+1)/2-partitionX;
            
            
            int maxLeftnums1 = (partitionX==0)?Integer.MIN_VALUE:nums1[partitionX-1];
            int minRightnums1 = (partitionX==x)?Integer.MAX_VALUE:nums1[partitionX];
            
            int maxLeftnums2 = (partitionY==0)?Integer.MIN_VALUE:nums2[partitionY-1];
            int minRightnums2 = (partitionY==y)?Integer.MAX_VALUE:nums2[partitionY];
            
            if(maxLeftnums1<=minRightnums2 && minRightnums1>=maxLeftnums2){
                if((x+y)%2 == 0){
                    return (double)(Math.max(maxLeftnums1,maxLeftnums2)+Math.min(minRightnums1,minRightnums2))/2;
                }else{
                    return (double)Math.max(maxLeftnums1,maxLeftnums2);
                }
            }
            else if(maxLeftnums1>minRightnums2){
                r = partitionX-1;
            }else{
                l = partitionX+1;
            }
        }return 0;
    }
}