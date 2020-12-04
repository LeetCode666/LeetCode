package exam;

import java.util.Stack;

public class leetcode155 {
	private Stack<Integer> stack;
    private Stack<Integer> helper;
    
    /** initialize your data structure here. */
    public leetcode155() {
        stack = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(helper.isEmpty()||helper.peek()>x)
            helper.push(x);
        else
            helper.push(helper.peek());
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            helper.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        throw new RuntimeException("the stack is empty");
    }
    
    public int getMin() {
        if(!helper.isEmpty())
            return helper.peek();
        throw new RuntimeException("the stack is empty");
    }
}


