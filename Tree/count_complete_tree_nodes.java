class Solution {
    public int countNodes(TreeNode root) {
        int res = helper(root);
        return res;
    }
    
    int helper(TreeNode root){
        if(root == null)return 0;
        int x = helper(root.left);
        int y = helper(root.right);
        return x+y+1;
    }
}