class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = 0;
        int m = matrix[0].length-1;
        boolean ans = false;
        while(n>=0 && n<matrix.length && m >=0 && m<matrix[0].length){
            if(matrix[n][m] == target)return true;
            if(matrix[n][m]>target)m--;
            else n++;
        }return false;
    }
}