/*
 * 题目：Lintcode - Last Position of Target
 * 题意：找到target，返回最后的位置
 * 思路：Binary Search
 * 时间复杂度： 
 * 空间复杂度： 
 * 相关题目：
 			
 * 哪些条件提示我想到这个解法： 
 * 模板：
 	public class Solution { 
 		init start, end
 		while (终止条件：start + 1 < end) {		// 区间缩小到两个数
			init mid
			移动指针（nums[mid] 和 target 比较）	//记得要用if..else if.. 而不能一直用if。因为一个while循环里面只做一件事
 		}
 		// 根据求 first/last position 决定先出nums[start] 和 nums[end]
 		return 结果（比较nums[end]/[start] 和 target 的值）
 		
    }  
 
}  
 */
public class Solution {
	public int lastPosition(int[] nums, int target){

	}
}