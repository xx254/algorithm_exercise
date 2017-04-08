public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        
        if(A == null || B == null ||  A.length() == 0 || B.length() == 0){
            return 0;
        }
        int a = A.length();
        int b = B.length();
        
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[a][b];
        
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                if(A.charAt(i) == B.charAt(j)){
                    // 或者可以开辟int[a+1][b+1]的数组，就省去初始化直接开始比较，因为默认填0
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}