package exam;

import java.util.Stack;

public class leetcode946 {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int pop = 0;
        for(int curInt : pushed){
            stack.push(curInt);
            while(!stack.empty() && popped[pop] == stack.peek()){
                stack.pop();
                pop++;
            }
        }
        return stack.empty();
    }
}
