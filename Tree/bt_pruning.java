class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(isLeaf(root) && root.val!=1)root = null;
        return root;
        
    }
    
    boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null)return true;
        return false;
    }
}