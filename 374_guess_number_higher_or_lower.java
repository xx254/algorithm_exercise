/*
 * 关联题目：Lintcode - Last Position of Target
 * 相同：
        在最后return pos的时候，也分成nums[end], nums[start] 和 target 的比较 
 * 不同：  
        
 * 疑问：
        
 * 时间复杂度：
        logn
 */
 
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n;
        while(start + 1 < n){
            int mid = start + (end - start) / 2;
            if(guess(mid) == -1){
                end = mid;
            }
            else if(guess(mid) == 1){
                start = mid;
            }
            else
                return mid;
        }
        
        if(guess(start) == 0)       // 不能写成 !guess(start)
            return start;
        else if(guess(end) == 0)
            return end;
        else
            return 0;
    }
}