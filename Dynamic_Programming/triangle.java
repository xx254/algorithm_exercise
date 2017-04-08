public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        int row = triangle.length;
        int col = 2;
        int[][] dp = new int[row][row];
        
        // init
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
        
        // top down
        for(int i=1; i<row; i++){
            for(int j=1; j<i; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        int mini = dp[row-1][0];
        for(int i=0; i<dp[row-1].length; i++){
            mini = Math.min(mini, dp[row-1][i]);
        }
        return mini;
    }
}



// Similar Question - Minimum Path Sum

public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        
        // init
        dp[0][0] = grid[0][0]; 
        for(int i=1; i<row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j=1; j<col; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        
        // top down
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}

// Similar Question - Unique Path
public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here  
        int path[][]  =  new int[m][n];
        
        path[0][0] = 0;
        for(int i = 1;i<n;++i){
            path[0][i]=1;
        }
        
        for(int i = 1;i<m;++i){
            path[i][0]=1;
        }
        
        for(int i = 1;i<m;++i){
            for(int j=1;j<n;++j){
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        
        return path[m-1][n-1];
    }
}

// Similar Question - Unique Path II

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Corner case, easily lost
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        
        // init
        dp[0][0] = 1;
        for(int i=1; i<row; i++){
            if(dp[i-1][0] == 0 || obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            }
            else{
                dp[i][0] = 1;
            }
        }
        for(int j=1; j<col; j++){
            if(dp[0][j-1] == 0 || obstacleGrid[0][j] == 1){
                dp[0][j] = 0;
            }
            else{
                dp[0][j] = 1;
            }
        }
        
        // top down
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        
        return dp[row-1][col-1];
    }
}
