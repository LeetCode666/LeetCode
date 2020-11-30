package exam;

import java.util.Stack;

public class leetcode901 {
	Stack<int[]> stack;
    public leetcode901() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int res = 1;
        while(!stack.empty() && stack.peek()[0] <=price){
            res += stack.pop()[1];
        }
        stack.push(new int[]{price, res});
        return res;
    }
}
