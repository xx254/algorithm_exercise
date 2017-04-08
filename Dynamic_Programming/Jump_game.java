
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here

        int n = A.length;
        boolean[] jump = new boolean[n];
        jump[0] = true;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(jump[j] && A[j] + j >= i){
                    jump[i] = true;
                }
                break;      //good 
            }
        }
        return jump[n-1];
    }
}

// Similar Question ** Jump Game II
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A.length == 1){
            return 1;
        }
        int n = A.length;
        int[] stp = new int[n];
        stp[0] = 0;
        
        // init
        for (int i = 1; i < A.length; i++) {
            stp[i] = Integer.MAX_VALUE;
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(stp[j] != Integer.MAX_VALUE && j + A[j] >= i){
                    stp[i] = Math.min(stp[i], stp[j]+1);
                }
            }
        }
        return stp[n-1];
    }
}
