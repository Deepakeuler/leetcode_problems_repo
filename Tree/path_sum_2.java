class Solution {
    List<List<Integer>>list = new ArrayList<>();//making universal list as answer to be added in it by function we'll be creating
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        Stack<Integer> st = new Stack<>();//will be storing the 
        if(root == null)return list;
        helper(root,targetSum,st);
        return list;
    }
    void helper(TreeNode root, int targetSum, Stack<Integer>st){
        st.push(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                list.add(new ArrayList<Integer>(st));
            }
        }
        if(root.left!=null)helper(root.left,targetSum-root.val,st);
        if(root.right!=null)helper(root.right,targetSum-root.val,st);
        st.pop();
    }
}