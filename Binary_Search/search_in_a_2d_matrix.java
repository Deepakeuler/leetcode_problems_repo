class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = n*m-1;
        if(n == 0|| m == 0)return false;
        while(l<=r){
            int mid = l +(r-l)/2;
            int target1 = matrix[mid/m][mid%m];
            if(target1==target){
                return true;
            }
            else if(target1>target){
                r = mid-1;
            }else l = mid+1;
        }return false;
    }
}