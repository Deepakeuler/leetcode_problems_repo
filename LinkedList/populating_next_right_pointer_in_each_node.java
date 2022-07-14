class Solution {
    public Node connect(Node root) {
        if(root == null)return null;
        List<List<Node>>output = new ArrayList<>();
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Node>list = new ArrayList<>();
            int size = q.size();
            for(int i =0; i<size; i++){
                Node removed = q.remove();
                list.add(removed);
                if(removed.left!=null)q.add(removed.left);
                if(removed.right!=null)q.add(removed.right);
            }output.add(list);
        }
        helper(output);
        return root;
    }
    void helper(List<List<Node>>output){
        int size = output.size();
        for(int i =0; i<size; i++){
            List<Node>sub = output.get(i);
            for(int j = 0; j<sub.size()-1; j++){
                sub.get(j).next = sub.get(j+1);
            }sub.get(sub.size()-1).next = null;
        }
    }
    
}
