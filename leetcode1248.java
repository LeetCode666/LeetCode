package exam;

import java.util.HashMap;
import java.util.Map;

public class leetcode1248 {
	public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int pre = 0;
        map.put(0,1);
        for(int i = 0; i < nums.length;i++){
            if(nums[i]%2 == 1)
                pre++;
            if(map.containsKey(pre - k)){
                count += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return count;
    }
}
