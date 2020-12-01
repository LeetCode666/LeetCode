package exam;

public class leetcode456 {
	public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;
        for(int i = nums.length-1; i >=0;i--){
            while(!stack.empty() && stack.peek()<nums[i]){
                secondMax = stack.pop();
            }
            if (nums[i] > secondMax) stack.push(nums[i]);
            if (nums[i] < secondMax) return true;
        }
        return false;
    }
}
