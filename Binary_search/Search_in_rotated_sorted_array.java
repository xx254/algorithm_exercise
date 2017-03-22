public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0){
            return -1;
        }
        
        //System.out.println(A.length);
        
        int start = 0, end = A.length - 1;
        int mid = 0;
        int hrz = A[0];
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (A[mid] == hrz){  //会有这种情况么？
                continue;
            }
            else if (A[mid] > hrz){
                if (target >= hrz && target <= A[mid]){
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
            else {   //A[mid] < hzr
                if (target >= A[mid] && target < hrz){
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }
        if (A[start] == target){
            return start;
        }
        else if (A[end] == target){
            return end;
        }
        else {
            return -1;
        }
    }
}