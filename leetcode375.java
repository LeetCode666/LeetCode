package exam;

public class leetcode375 {
	public int getMoneyAmount(int n) {
        if(n ==1) return 0;
        int[][] dp = new int[n+1][n+1];
        for(int j = 2; j <= n;j++){
            for(int i = j-1; i >=1;i--){
                int a = Math.min(i+dp[i+1][j], j + dp[i][j-1]);
                int min = Integer.MAX_VALUE;
                for(int k = i+1; k <=j-1;k++){
                    int temp = k + Math.max(dp[i][k-1], dp[k+1][j]);
                    min = Math.min(temp, min);
                }
                dp[i][j] = Math.min(min, a);
            }
        }
        return dp[1][n];
    }
}
