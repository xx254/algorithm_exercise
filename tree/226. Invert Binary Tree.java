class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode oriLeft = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(oriLeft);
        return root;
    }
}
