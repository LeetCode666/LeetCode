package exam;

import java.util.Stack;

public class leetcode739 {
	public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < T.length;i++){
            while(!stack.empty() && T[stack.peek()]<T[i]){
                int cur = stack.pop();
                res[cur] = i-cur;
            }
            stack.push(i);
        }
        return res;
    }
}
