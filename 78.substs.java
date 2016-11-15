/*
 * 题目：78. Subset
 * 题意：找到一个array的所有subset
 * 思路：DFS
 * 时间复杂度： 2^n * n (递归次数 2^n, for循环里n)
 * 空间复杂度： 2^n * n (递归次数 2^n, 每次list长度n)
 * 相关题目：
 			Permutations
 			Unique Permutations
 			Combination Sum
 			Letter Combination of a Phone number
 			Palindrome partitioning
 			Restore IP Address
 * 哪些条件提示我想到这个解法： ALL possible solutions
 * 模板：
 	public class Solution { 
 		初始化res，path
 		Arrays.sort()
 		dfs();
		return;
    }  
      
    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos){  
        把path拍照放入结果中
        for循环 （增，dfs，删）
    }  
}  
 */

public class Solution {
	public List<List<Integer>> subsets(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();   //question 1 ArrayList/List
		if(num == null || num.length == 0)      //error 2: nums/num
			return res;
		List<Integer> path = new ArrayList<Integer>();
		Arrays.sort(num);
		dfs(res, path, num, 0);
		return res;
	}

	public void dfs(List<List<Integer>> res, List<Integer> path, int[] num, int pos) {
		res.add(new ArrayList<Integer>(path));		//error 1
		for(int i = pos; i < num.length; i++){
			path.add(num[i]);
			dfs(res, path, num, ++pos);             //question/error 2：pos++不行，pos+1不行，i+1可以，++pos可以
			path.remove(path.size() - 1);
		}
	}
}

//Line 42: error: List is abstract; cannot be instantiated