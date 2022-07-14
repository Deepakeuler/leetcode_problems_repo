/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        if(root == null)return res;
        q.add(root);
        while(!q.isEmpty()){
            level++;
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
                
            }
            if(level % 2 == 0){
                list = reverse(list);
                res.add(list);
            }
            else {
                res.add(list);
            }
        }return res;
    }
    
    public List<Integer> reverse(List<Integer> list){
        int left = 0, right = list.size()-1;
        while(left < right){
            int leftElement = list.get(left);
            int rightElement = list.get(right);
            //
            list.set(left, rightElement);
            list.set(right, leftElement);
            
            left++;right--;
            
        }
        return list;
    }
}