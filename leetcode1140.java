package exam;

public class leetcode1140 {
	public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] suffixSum = new int[len + 1];
        suffixSum[len] = 0;
        for (int i = len - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = suffixSum[i];
                    continue;
                }
                for (int X = 1; X <= 2 * M; X++) {
                    dp[i][M] = Math.max(dp[i][M], suffixSum[i] - dp[i + X][Math.max(X, M)]);
                }
            }
        }
        return dp[0][1];
     }
}
