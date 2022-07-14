class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int res = 0;
        if(root == null)return res;
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int sum =0;
            for(int i = 0; i<size; i++){
                TreeNode removed = q.remove();
                sum+=removed.val;
                if(removed.left!=null){
                    q.add(removed.left);
                }if(removed.right!=null){
                    q.add(removed.right);
                }
            }
            res = sum;
            
        }return res;
    }
}