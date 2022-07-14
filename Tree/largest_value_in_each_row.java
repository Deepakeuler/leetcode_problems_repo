class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return list;
        q.add(root);
        while(!q.isEmpty()){
            
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode removed = q.remove();
                max = Math.max(max,removed.val);
                if(removed.left!=null){
                    q.add(removed.left);
                }
                if(removed.right!=null){
                    q.add(removed.right);
                }
            }list.add(max);
            
        }return list;
    }
}