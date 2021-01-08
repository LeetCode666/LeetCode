package exam;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums.length == 0) return new int[0];
        int[] res  = new int[nums.length-k+1];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            while(!queue.isEmpty() && nums[queue.peekLast()]<cur){
                queue.pollLast();
            }
            while(!queue.isEmpty() && queue.peekFirst()<= i-k){
                queue.pollFirst();
            }
            queue.offerLast(i);
            if(i-k+1 >=0){
                res[i-k+1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
