package exam;

public class leetcode494 {
	public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if((sum+S)%2 != 0 || sum < S) return 0;
        int amount = (sum + S)/2;
        int[][] dp = new int[nums.length+1][amount+1];
        dp[0][0] = 1;
        for(int i = 1; i < nums.length+1;i++){
            for(int j = 0; j < amount+1;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][amount];
    }
}
