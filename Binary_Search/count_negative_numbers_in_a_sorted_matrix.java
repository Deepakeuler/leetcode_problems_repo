class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0 ;
        for(int i = 0; i < grid.length; i++){
            res += check(grid[i]);
        }
        return res;
    }
    
    
    private int check(int [] arr){
        int l = 0;
        int r = arr.length-1;
        int res = 0;
        while(l <=r){
            int mid = l + (r-l)/2;
            if(arr[mid]>=0)l = mid+1;
            else if(arr[mid]<0){
                res+=r-mid+1;
                r = mid-1;
            }
        }return res;
    }
}