package exam;

public class leetcode486 {
	public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] memo = new int[len][len];

        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return dfs(nums, 0, len - 1, memo) >= 0;
    }

    private int dfs(int[] nums, int i, int j, int[][] memo) {
        if (i == j) {
            return nums[i];
        }

        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        
        int chooseLeft = nums[i] - dfs(nums, i + 1, j, memo);
        int chooseRight = nums[j] - dfs(nums, i, j - 1, memo);
        memo[i][j] = Math.max(chooseLeft, chooseRight);
        return memo[i][j];
    }
}
