// Two Sum 的 简化+tree版
class Solution {
    HashSet<Integer> hs = new HashSet<Integer>();
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        if(hs.contains(root.val)){
            return true;
        } else {
            hs.add(k - root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }
}
