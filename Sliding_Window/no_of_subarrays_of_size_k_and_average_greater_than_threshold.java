class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int l = 0, r = 0, count = 0, n = arr.length, ans = 0;
        
        while(r < n){
            int right = arr[r];
            count += right;
            
            while(r - l + 1 > k){
                count -= arr[l];
                l++;
            }
            if((r - l + 1) == k && (count / k) >= threshold) ans++;
            r++;
        }
        return ans;
    }
}