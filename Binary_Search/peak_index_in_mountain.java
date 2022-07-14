class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int r = n-1;
        int l = 0;
        int index = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]>arr[mid+1]&& arr[mid]>arr[mid-1]){
                index = mid;
                return index;
            }
            else if(arr[mid]>arr[mid+1]){
                r = mid-1;
                
            }else l = mid+1;
        }return index;
    }
}