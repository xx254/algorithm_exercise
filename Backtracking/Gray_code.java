/*
    Idea: 
        1. Whenever n++, the size of the list doubles:
            n = 0:  0
            n = 1:  0 | 1
            n = 2:  00, 01 | 11, 10
            n = 3:  000, 001, 011, 010 | 110, 111, 101, 100
        2. Apart from the most significant bit, the rest is symmetric.
*/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        
        res.add(0);
        
        if(n == 0){
            return res;
        }
        else{   
            for(int i = 0; i < n; i++){
                for(int end = res.size() - 1; end >= 0; end--){
                    // "+" has higher priority than "<<"
                    res.add(res.get(end) + (1 << i));
                }
            }
        }
        return res;
    }
}