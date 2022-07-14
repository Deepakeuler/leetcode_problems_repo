class Solution {
    public int maxLevelSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)return 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0; i<size; i++){
                TreeNode removed = q.remove();
                sum += removed.val;
               
                if(removed.left != null){
                    q.add(removed.left);
                }if(removed.right != null){
                    q.add(removed.right);
                }
            }
             res.add(sum);
        }
        //System.out.println(res);
        int max = Integer.MIN_VALUE;
        int indexToBeReturned =-1;
        for(int i = 0; i<res.size(); i++){
            
            if(res.get(i) > max) {
                max = res.get(i);
                
                indexToBeReturned = i;
        //System.out.println("answer level updated to : "+indexToBeReturned);
                
            }
        }
        return indexToBeReturned+1;
    }
}