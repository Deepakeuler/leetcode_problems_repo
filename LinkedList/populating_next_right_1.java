class Solution {
    public Node connect(Node root) {
        if(root == null)return root;
        List<List<Node>>output = new ArrayList<>();
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Node> list = new ArrayList<>();
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
        for(int i = 0;i<size; i++){
            List<Node>inner = output.get(i);
            for(int j =0; j<inner.size()-1; j++){
                inner.get(j).next = inner.get(j+1);
            }inner.get(inner.size()-1).next = null;
        }
    }
}