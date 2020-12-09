package exam;

import java.util.List;
import java.util.Stack;

public class leetcode636 {
	public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(String log : logs){
            String[] part = log.split(":");
            int id = Integer.valueOf(part[0]);
            int value = Integer.valueOf(part[2]);
            if(part[1].equals("start")){
                stack.push(new int[]{id, value});
            }
            else{
                int[] cur = stack.pop();
                int diff = value - cur[1] + 1;
                res[id] += diff;
                if(!stack.empty()){
                    res[stack.peek()[0]] -= diff;
                }
            }
        }
        return res;
    }
}
