class Solution {
    public void flatten(TreeNode root) {
        if(root == null)return;
       Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode removed = st.pop();
            if(removed.right!=null){
                st.push(removed.right);
            }
            if(removed.left != null){
                st.push(removed.left);
            }if(!st.isEmpty()){
                removed.right = st.peek();
            }removed.left = null;
        }
    }
}