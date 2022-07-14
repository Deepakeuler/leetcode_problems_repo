class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)return root;
        TreeNode res = isLeaf(root,target);
        return res;
    }
    static TreeNode isLeaf(TreeNode root,int target){
        if(root == null)return null;
        root.left = isLeaf(root.left, target);
        root.right = isLeaf(root.right, target);
        if(root.right == null && root.left == null && root.val == target){
            root = null;
        }return root;

    }
}