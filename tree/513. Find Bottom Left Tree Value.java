/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 怎么样在每一层之内找最左呢？每一层有一个数来保存，所有行组成一个数组。右边不加一左边减一，这样可以保证取到最左而不落下只有右子树的情况
// Integer.MAX_VALUE + 1 溢出，变成绝对值很大的负数

class Solution {
    int res = 0;
    int maxDepth = 0;
    int[] pos;
    
    public void findMaxDepth(TreeNode root, int depth){
        if(root == null){
            return;
        }
        findMaxDepth(root.left, depth+1);
        findMaxDepth(root.right, depth+1);
        if(depth > maxDepth){
            maxDepth = depth;
        }
    }
    
    public int findBottomLeftValue(TreeNode root) {
        findMaxDepth(root, 0);
        System.out.println("maxDepth is : "+ maxDepth);
        int[] pos = new int[maxDepth+1];
        findAllPos(root, 0, 0, pos);
        return res;
    }
    
    
    public void findAllPos(TreeNode root, int cur, int depth, int[] pos){
        if(root == null){
            return;
        }
        if(depth == maxDepth && cur <= pos[depth]){
            pos[depth] = cur;
            res = root.val;
        }
        findAllPos(root.right, pos[depth], depth+1, pos);
        findAllPos(root.left, pos[depth]-1, depth+1, pos);
    }
}


//--------- res[1]保存最大的depth，res[0]保存当前行--------- 
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        // 说明已经换行，左边的永远先执行，优先占据res[0]的位置
        if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
        
        return res[0];
    }
}

//--------- BFS --------- 
public int findLeftMostNode(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        root = queue.poll();
        if (root.right != null)
            queue.add(root.right);
        if (root.left != null)
            queue.add(root.left);
    }
    return root.val;
}
