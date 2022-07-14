class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            List<Integer> l = new ArrayList<>();
            return l;
        }
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> innerlist = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode removed = q.remove();
                innerlist.add(removed.val);
                if(removed.right!=null){
                    q.add(removed.right);
                }
                if(removed.left!=null){
                    q.add(removed.left);
                }
            }list.add(innerlist.get(0));
        }
        return list;
    }
}