package exam;

import java.util.Arrays;

public class leetcode1547 {
	public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] temp = new int[len+2];
        for(int i = 0; i < len;i++){
            temp[i] = cuts[i];
        }
        temp[len] = 0;
        temp[len+1] = n;
        Arrays.sort(temp);
        return dfs(temp, 0, len+1, new Integer[len+2][len+2]);
    }
    
    private int dfs(int[] A, int l, int r, Integer[][] memo){
        if(l+1 == r) return 0;
        if(memo[l][r] != null) return memo[l][r];
        int cost = A[r] - A[l];
        int res = Integer.MAX_VALUE;
        for(int i = l+1; i < r;i++){
            res = Math.min(res, dfs(A, l, i, memo) + dfs(A, i, r, memo) + cost);
        }
        if(res == Integer.MAX_VALUE) res = 0;
        memo[l][r] = res;
        return res;
    }
}
