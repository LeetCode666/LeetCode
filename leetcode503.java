package exam;

import java.util.Stack;

public class leetcode503 {
	public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i <res.length;i++){
            res[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 2*(res.length)-1;i++){
            int cur = i % (nums.length);
            while(!stack.empty() && nums[stack.peek()]< nums[cur]){
                res[stack.pop()] = nums[cur];
            }
            stack.push(cur);
        }
        return res;
    }
}
