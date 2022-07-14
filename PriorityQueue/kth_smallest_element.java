class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix[0].length;
        int n = matrix.length;
        int t = n*m;
        int i = 0;
        int []arr = new int [t];
        for(int[]ar :matrix){
            for(int x:ar){
                arr[i]=x;
                i++;
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}