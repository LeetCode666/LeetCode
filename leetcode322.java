package exam;

import java.util.Arrays;

public class leetcode322 {
	public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i : coins){
            for(int j = i; j < amount +1;j++){
                dp[j] = Math.min(dp[j], dp[j - i]+1);
            }
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
