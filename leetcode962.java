package exam;

import java.util.Stack;

public class leetcode962 {
	public int maxWidthRamp(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n;i++){
            if(stack.empty() || A[stack.peek()]>A[i]){
                stack.push(i);
            }
        }
        
        int res = 0;
        for(int i = n-1; i >=0; i--){
            while(!stack.empty() && A[stack.peek()] <= A[i]){
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}
