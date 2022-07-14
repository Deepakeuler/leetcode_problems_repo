class Solution {
    HashMap<String,Integer>hm=new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        mapper(root);
        return list;
    }
    String mapper(TreeNode root){
        if(root == null)return "N";
        String left = mapper(root.left);
        String right = mapper(root.right);
        String curr = root.val+" "+ left+" "+right;
        hm.put(curr,hm.getOrDefault(curr,0)+1);
        if(hm.get(curr)==2)list.add(root);
        return curr;
    }
}