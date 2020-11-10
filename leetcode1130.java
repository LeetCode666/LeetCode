package exam;

public class leetcode1130 {
	public int mctFromLeafValues(int[] arr) {
        return dfs(0, arr.length-1, arr, new Integer[arr.length][arr.length]);
    }
    
    private int dfs(int l, int r, int[] arr, Integer[][] memo){
        if(l>=r) return 0;
        if(memo[l][r]!=null) return memo[l][r];
        int res = Integer.MAX_VALUE;
        for(int i = l; i < r;i++){
            int leftMax = getMax(arr, l, i);
            int rightMax = getMax(arr, i+1, r);
            res = Math.min(res, dfs(l, i,arr, memo) + dfs(i+1, r, arr, memo) + leftMax*rightMax);
        }
        memo[l][r] = res;
        return memo[l][r];
    }
    
    public int getMax(int arr[] , int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i = start ; i <= end ; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
