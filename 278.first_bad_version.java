/*
 * 关联题目：Lintcode - Last Position of Target
 * 相同：
        在最后return pos的时候，也分成nums[end], nums[start] 和 target 的比较 
 * 不同：  
        
 * 疑问：
        
 * 时间复杂度：
        logn
 */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //if(n < = 0)
        //    return 0;
        int start = 1, end = n;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(isBadVersion(mid)){
                end = mid;
            }
            else if(!isBadVersion(mid)){
                start = mid;
            }
        }
        if(isBadVersion(start))
            return start;
        if(isBadVersion(end))
            return end;
        else 
            return 0;
    }
}