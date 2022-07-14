class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
        while(!q.isEmpty()){
            TreeNode removed = q.remove(); 
            if(removed == null)end = true;
            else{
                if(end)return false;
                q.add(removed.left);
                q.add(removed.right);
            }
        }return true;
    }
}