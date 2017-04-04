public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<String>();
        HashSet<String> opr = new HashSet<String>();
        int a=0, b=0, c=0;
        opr.add("+");
        opr.add("-");
        opr.add("*");
        opr.add("/");
        
        //pop 的顺序
        for(int i =0; i<tokens.length; i++){
            if(opr.contains(tokens[i])){
                if(!st.empty()){
                    b = Integer.parseInt(st.pop());
                }
                if(!st.empty()){
                    a = Integer.parseInt(st.pop());
                }
                st.push(String.valueOf(calculate(a, b, tokens[i])));
            }
            else{
                st.push(tokens[i]);
            }
        }
        if(!st.empty()){
            return Integer.parseInt(st.pop());
        }
        return -1;
    }
    
    public int calculate(Integer a, Integer b, String opr){
        if(opr.equals("+")){
            return a+b;
        }
        else if(opr.equals("-")){
            return a-b;
        }
        else if(opr.equals("*")){
            return a*b;
        }
        else{
            return a/b;
        }
    }
}