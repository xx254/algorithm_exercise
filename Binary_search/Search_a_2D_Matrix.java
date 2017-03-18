 class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0 )
            return false;
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row * col - 1;
        int mid = 0;
        while(start + 1 < end){
            mid = (start + end) / 2;
            if(matrix[mid/col][mid%col] > target){
                end = mid;
            }
            else if(matrix[mid/col][mid%col] < target){
                start = mid;
            }
            else if(matrix[mid/col][mid%col] == target){
                return true;
            }
        }
        if(matrix[start/col][start%col] == target){
            return true;
        }
        else if((matrix[end/col][end%col] == target)){
            return true;
        }
        else{
            return false;
        }
    }
}
        
        
    

