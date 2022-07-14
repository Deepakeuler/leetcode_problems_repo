class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int ans = -1;
        Queue<TreeNode> q = new LinkedList<>();
        if(root.left == null && root.right == null)return root.val;
        q.add(root);
        while(!q.isEmpty()){
           // int size = q.size();
            root = q.remove();
            
            if(root.right != null){
                q.add(root.right);
            }
            if(root.left != null){
                q.add(root.left);
                
            }
        }return root.val;
    }
}