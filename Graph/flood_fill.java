class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sourceColor = image[sr][sc];
        if(sourceColor == color)return image;
        else{
            helper(image,sourceColor,color,sr,sc);
        }return image;
    }
    
    void helper(int[][]image,int sourceColor, int newColor,int i, int j){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=sourceColor || image[i][j]==newColor){
            return;
        }
        image[i][j] = newColor;
        helper(image,sourceColor,newColor,i+1,j);
        helper(image,sourceColor,newColor,i-1,j);
        helper(image,sourceColor,newColor,i,j+1);
        helper(image,sourceColor,newColor,i,j-1);
        
    }
}