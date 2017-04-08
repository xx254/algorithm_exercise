public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        // write your code here
        int n = nums.length;
        int[] lis = new int[n];
        int max = Integer.MIN_VALUE;
        
        // func
        for(int i=0; i<n; i++){
            //init 
            lis[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    lis[i] = Math.max(lis[j]+1, lis[i]);      
                }
            }
            max = Math.max(max, lis[i]);
        }
        
        return max;
    }
}
