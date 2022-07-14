class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode res = new TreeNode(val);
            return res;
        }
        if(root.val<val){
            root.right = insertIntoBST(root.right,val);
        }
        if(root.val>val){
            root.left = insertIntoBST(root.left,val);
        }return root;
    }
}