/*
 * 题目：90. Subset II
 * 题意：找到一个array的所有subset，subset不重复
 * 思路：DFS
 * 时间复杂度： 
 * 空间复杂度： 
 * 相关题目：
        78.Subsets
 * 哪些条件提示我想到这个解法： 
 * 模板：
    public class Solution { 
        初始化res，path
        Arrays.sort()
        dfs();
        return;
    }  
      
    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos){  
        把path拍照放入结果中
        for循环 （增，dfs，删） //在for中处理path，因此要在for循环中添加对path的限制条件
    }  
}  
 */

public class Solution {  
    public List<List<Integer>> subsetsWithDup(int[] nums) {  
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(res, path, nums, 0);
        
        return res;
        
    }  
      
    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int pos){  
        
        res.add(new ArrayList<Integer>(path));
        
        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i] == nums[i-1])
                continue;
            path.add(nums[i]);
            dfs(res, path, nums, i+1);
            path.remove(path.size() - 1);
        }
    }  
}  

//Line 3: error: incompatible types: ArrayList<ArrayList<Integer>> cannot be converted to List<List<Integer>>