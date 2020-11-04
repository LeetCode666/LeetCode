package exam;

public class leetcode312 {
	public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n+2];
        temp[0] = 1;
        temp[n+1] = 1;
        for(int i=0; i<n; i++){
            temp[i+1] = nums[i];
        }
        return dfs(temp, 0 , temp.length-1, new Integer[temp.length][temp.length]);
    }
    
    private int dfs(int[] A, int i, int j, Integer[][] memo){
        if(i + 2 > j) return 0;
        if(memo[i][j]!=null) return memo[i][j];
        int res = Integer.MIN_VALUE;
        for (int k = i + 1; k < j; ++k) {
            res = Math.max(res, dfs(A, i, k, memo) + dfs(A, k, j, memo) + A[i] * A[k] * A[j]);
        }
        
        memo[i][j] = res;
        return memo[i][j];
    }
}
