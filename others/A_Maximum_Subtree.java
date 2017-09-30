public class Demo {

    static int max = Integer.MIN_VALUE;
    static TreeNode res = null;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode findSubtree(TreeNode root) {
        nodeSum(root);
        return res;
    }

    public static int nodeSum(TreeNode node){
        int sum = node.val;
        if(node.left != null){
            sum += nodeSum(node.left);
        }
        if(node.right != null) {
            sum += nodeSum(node.right);
        }
        if(sum > max){
            res = node;
            max = sum;
        }
        return sum;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-4);
        root.right.right = new TreeNode(-5);
        findSubtree(root);
        System.out.println(res.val);

    }
}
