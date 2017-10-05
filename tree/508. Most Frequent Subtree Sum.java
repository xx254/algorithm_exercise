/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//算出每个点的sum，再看谁的频率最大
class Solution {
    public int addSum(TreeNode root, List<Integer> list){
        if(root == null){
            return 0;
        }
        int left = addSum(root.left, list);
        int right = addSum(root.right, list);
        int cur = root.val + left + right;
        list.add(cur);
        return cur;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        addSum(root, list);
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i=0; i<list.size(); i++){
            int num = list.get(i);
            if(!h.containsKey(num)){
                h.put(num, 1);
            } else {
                h.put(num, h.get(num) + 1);
            }
        }
        int maxFre = 0, count = 0;
          
        //get max frequency
        for(Map.Entry<Integer, Integer> entry : h.entrySet()){
            int number = entry.getKey();
            // System.out.println("number " + number);
            int fre = entry.getValue();
            // System.out.println("fre " + fre);
            if(fre > maxFre){
                maxFre = fre;
                count = 1;
            } else if(fre >= maxFre){
                count++;
            }
        }
        
        int[] res = new int[count];
        count = 0;
        for(Map.Entry<Integer, Integer> entry : h.entrySet()){
            if(entry.getValue() == maxFre){
                res[count] = entry.getKey();
                count++;
            }
        }
        return res;
    }
}
