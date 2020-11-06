package exam;

public class leetcode664 {
	public int strangePrinter(String s) {
		int len = s.length();
		return dfs(0, len-1, s, new Integer[len][len]);
	}

	private int dfs(int l, int r, String s, Integer[][] memo){
		if(l>r) return 0;
		if(l == r) return 1;
		if(memo[l][r] != null) return memo[l][r];
		int res = dfs(l+1, r, s, memo) +1;
		for(int i = l+1; i <=r;i++){
			if(s.charAt(l) == s.charAt(i)){
				res = Math.min(res, dfs(l, i-1, s, memo) +(i+1 > r ? 0 : dfs(i+1, r, s, memo)));
			}
		}
		memo[l][r] = res;
		return memo[l][r];
	}
}
