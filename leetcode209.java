package exam;

public class leetcode209 {
	public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int cur = 0;
        for(int right = 0; right < nums.length;right++){
            cur+=nums[right];
            while(cur>=s){
                res = Math.min(right - left + 1,res);
                cur -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }
}
