package exam;

public class leetcode1406 {
	public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int[] dp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            int sum = 0;
            dp[i] = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(len, i + 3); j++) {
                sum += stoneValue[j];
                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }
        int diff = dp[0];
        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }
}
