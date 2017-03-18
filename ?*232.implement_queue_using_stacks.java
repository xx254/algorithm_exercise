/*
 * 题意：用stack实现queue
 * 思路：implementing data structure
 * 时间复杂度： 入队O(1) 出队O(N) peek O(N)
 * 空间复杂度： O(N) 
 * 相关题目：
 			
 * 哪些条件提示我想到这个解法： 
 * 模板：
 * 疑问：
 		1、注释的两行为什么可以行得通，peek是哪个stack在peek？
 		2、空间复杂度？
}  
 */


class MyQueue {
    
    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();
    
    public void push(int x) {
        input.push(x);
    }

    public void pop() {
        //peek();
        //output.pop();
        if(!output.isEmpty()) output.pop();  
        else {  
            while(!input.isEmpty()) output.push(input.pop());  
            output.pop();  
        } 
    }

    public int peek() {         //不要默认output非空
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}