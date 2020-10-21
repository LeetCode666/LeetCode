package exam;

public class leetcode518 {
	public int change1(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];
        dp[0][0] = 1;
        for(int i = 1; i < len+1;i++){
            for(int j = 0; j < amount+1;j++){
                dp[i][j] = dp[i-1][j];
                if(j >= coins[i-1])
                    dp[i][j] += dp[i][j-coins[i-1]];
            }
        }
        return dp[len][amount];
    }
	
	public int change2(int amount, int[] coins) {
		int[] dp = new int[amount+1];
		dp[0] = 1;
		for(int coin : coins){
			for(int i = coin; i <= amount;i++){
				dp[i] += dp[i-coin];
			}
		}
		return dp[amount];
	}
}
