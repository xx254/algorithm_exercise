// 树的问题容易错在corner case上，即停止的条件。这道题也可以写成 newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left); 的形式看起来更简洁。
class Solution {
    public int getValue(TreeNode t){
        if(t == null){
            return 0;
        } else {
            return t.val;
        }
    }
    public TreeNode getSubTree(TreeNode t, boolean left){
        if(t == null){
            return null;
        }
        
        if(left){
            return t.left;
        } else{
            return t.right;
        }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }
        int rootNum = 0;
        rootNum += getValue(t1) + getValue(t2);
        TreeNode root = new TreeNode(rootNum);
        root.left = mergeTrees(getSubTree(t1, true), getSubTree(t2, true));
        root.right = mergeTrees(getSubTree(t1, false), getSubTree(t2, false));
        return root;
    }
}
