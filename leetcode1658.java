package exam;

import java.util.HashMap;
import java.util.Map;

public class leetcode1658 {
	public int minOperations(int[] nums, int x) {
       int sum = 0;
       for (int num : nums) sum += num;
       int target = sum - x;

       int presum = 0;
       int res = Integer.MIN_VALUE;
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, -1); 
		
       for (int i = 0; i < nums.length; i++) {
           presum += nums[i];
           map.put(presum, i);
           if (map.containsKey(presum - target)) {
               res = Math.max(res, i - map.get(presum - target));
           }
       }
       
       if (res == Integer.MIN_VALUE) return -1;
       return nums.length - res;
   }
}
