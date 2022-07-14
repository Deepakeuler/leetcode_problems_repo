class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)return res;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode removed = q.remove();
                list.add(removed.val);
                if(removed.left != null){
                    q.add(removed.left);
                }if(removed.right != null){
                    q.add(removed.right);
                }
            }res.add(list);
        }
        Collections.reverse(res);return res;
    }
}