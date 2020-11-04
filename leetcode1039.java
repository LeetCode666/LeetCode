package exam;

public class leetcode1039 {
	public int minScoreTriangulation(int[] A) {
        return dfs(A, 0 , A.length-1, new Integer[A.length][A.length]);
    }
    
    private int dfs(int[] A, int i, int j, Integer[][] memo){
        if(i + 2 > j) return 0;
        if(memo[i][j]!=null) return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) {
            res = Math.min(res, dfs(A, i, k, memo) + dfs(A, k, j, memo) + A[i] * A[k] * A[j]);
        }
        
        memo[i][j] = res;
        return memo[i][j];
    }
}
