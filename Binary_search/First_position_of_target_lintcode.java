class Solution {
    
    /*
    * start + 1 < end can ensure start == end - 1 when leaving the loop
    */

    public int binarySearch(int[] nums, int target) {
        //write your code here
        int start = 0, end = nums.length - 1;
        int mid = 0;
        while(start + 1 < end) {
            mid = (start + end) / 2;
            if(nums[mid] > target){
                end = mid;
            }
            else if (nums[mid] == target){
                end = mid;
            }
            else{   //nums[mid] < target
                start = mid;
            }
        }
        if(nums[start] == target){
            return start;
        }
        else if(nums[end] == target){  
            return end;
        }
        else{
            return -1;
        }
    }
}