class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null)return null;
        int lh = helper(root.left);
        int rh = helper(root.right);
        if(lh == rh)return root;
        if(lh<rh)return lcaDeepestLeaves(root.right);
        else return lcaDeepestLeaves(root.left);
    }
    int helper(TreeNode root){
        if(root == null)return -1;
        int left = helper(root.left);
        int right = helper(root.right);
        int ans = Math.max(left,right)+1;
        return ans;
    }
}