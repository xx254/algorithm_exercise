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


//同理：515. Find Largest Value in Each Tree Row
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                if(cur.val > max){
                    max = cur.val;
                }
            }
            res.add(max);
        }
        return res;
    }
}
