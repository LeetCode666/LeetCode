package exam;

public class leetcode1312 {
	public int minInsertions(String s) {
        String sReverse = new StringBuilder(s).reverse().toString();
        int n = lcs(s.toCharArray(), sReverse.toCharArray());
        return s.length() - n;
    }
    
    private int lcs(char[] a, char[] b){
        int m = a.length;
        int n = b.length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <=n ; j++){
                if(a[i-1] == b[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
