/*
 * 关联题目：Lintcode - Last Position of Target
 * 相同：
   		在最后return pos的时候，也分成nums[end], nums[start] 和 target 的比较 
 * 不同：  
    	nums[start]/[end] 和 target 的关系不是相等，而是不等于
 * 疑问：
 		怎么确定nums[start]/[end] 和 target 不等关系
 * 时间复杂度：
 		logn
 */

//no duplicate: 所以不用考虑first/last position的问题

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
            
        int start = 0, end = nums.length - 1;
        
        if(nums[start] > target)
           return 0;
        if(nums[end] < target)
            return nums.length;
            
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > target){
                end = mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else{       //nums[mid] == target
                return mid;
            }
        }
        
        if(nums[start] >= target)
            return start;
        //else if(nums[start] < target)
          //  return start+1;
        else if(nums[end] >= target)
            return end;
        else if(nums[end] < target)
            return end+1;
        else 
            return -1;
        
    }
}