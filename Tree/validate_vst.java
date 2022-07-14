class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        if(root.left!=null){
            int leftMax = max(root.left);
            if(leftMax>=root.val)return false;
        }
        if(root.right!=null){
            int rightMin = min(root.right);
            if(rightMin<=root.val)return false;
        }
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        return left&&right;
    }
    int max(TreeNode root){
        int ans = Integer.MIN_VALUE;
        if(root == null)return ans;
        int left = max(root.left);
        int right = max(root.right);
        int res = Math.max(root.val,Math.max(left,right));
        return res;
    }
    int min(TreeNode root){
        int ans = Integer.MAX_VALUE;
        if(root == null)return ans;
        int left = min(root.left);
        int right = min(root.right);
        int res = Math.min(root.val,Math.min(left,right));
        return res;
    }
}