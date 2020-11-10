package exam;

public class leetcode1246 {
	public int minimumMoves(int[] arr) {
        int len = arr.length;
        return dfs(0, len-1, arr, new Integer[len][len]);
    }
    
    private int dfs(int l, int r, int[] arr, Integer[][] memo){
        if(l>r)return 0;
        if(l == r) return 1;
        if(memo[l][r] != null) return memo[l][r];
        int res = dfs(l, r-1, arr, memo) +1;
        if(r > 0 && arr[r] == arr[r-1])
            res = Math.min(res, dfs(l, r-2, arr, memo)+1);
        for(int k = l; k <r-1;k++){
            if(arr[k] == arr[r]){
                res = Math.min(res, dfs(l, k-1, arr, memo) + dfs(k+1, r-1, arr, memo));
            }
        }
        memo[l][r] = res;
        return memo[l][r];
    }
}
