class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)return root.val;
        helper(root,k);
        return list.get(k-1);
    }
    
    void helper(TreeNode root,int k){
        if(root == null)return;
        helper(root.left,k);
        list.add(root.val);
        helper(root.right,k);
    }
}