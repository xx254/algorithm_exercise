// sum要是double的，虽然sum/int两者其一为double就可以使结果double但是sum是int的话会
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        List<Double> res = new ArrayList<>();
        double sum = 0;
        int num = 0.0;
        
        while(!q.isEmpty()){
            sum = 0.0;
            num = q.size();
            for(int i=0; i<num; i++){
                TreeNode cur = q.poll();
                sum += cur.val;
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            res.add(sum/num);
        }
        return res;
    }
}
