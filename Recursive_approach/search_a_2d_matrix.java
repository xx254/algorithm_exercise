public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        
        if(matrix==null || matrix.length==0) return false;
        
        int row=0;int col = matrix[0].length-1;
        
        return searchMatrix(matrix,row,col,target);
    }
        
         public boolean searchMatrix(int[][] mat,int row,int col,int target){
        if(row<0 || row>= mat.length || col<0 || col>mat[0].length)
            return false;
        if(mat[row][col] == target)
            return true;
        else if(mat[row][col] < target)
            return searchMatrix(mat,row+1,col,target);
        else
            return searchMatrix(mat,row,col-1,target);
    }
}
        
        
    
