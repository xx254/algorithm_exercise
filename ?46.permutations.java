/*
 *关联题目：subsets
 *相同：
    1. 都在dfs的最初处理"放path入res"的步骤
    2. for循环处理path
 *不同：  
    1. dfs的参数中不需要有pos。subset中构造path的条件是下一层dfs要在当前指针位置之后，而permutation构造path的条件是与之前的所有数字不重复；
    2. path不能简单地每一步添加到res中，而要有条件的添加。条件：达到一定长度；
 *疑问：初始化List/ArrayList
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        List<Integer> path = new ArrayList<Integer>();
        dfs(res, path, nums);
        
        return res;
    }
    

    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums){

        if(path.size() == nums.length){         //error1: path.size() 不是length
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){   //error2: 没有pos了
            if(path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            dfs(res, path, nums);
            path.remove(path.size() - 1);
        }
        
    }
}