package exam;

public class leetcode1049 {
	public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int num : stones){
            sum+=num;
        }
        int half = sum/2;
        
        int len = stones.length;
        boolean[][] dp = new boolean[len+1][half+1];
        dp[0][0] = true;
        for(int i = 1; i <len+1;i++){
            for(int j= 0; j < half+1;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=stones[i-1] && dp[i-1][j-stones[i-1]]){
                    dp[i][j] = true;
                }
            }
        }
        
        int res = 0;
        for(int i = half;i>=0;i--){
            if(dp[len][i]){
                res = i;
                break;
            }
        }      
        return sum - 2*res;
    }
}
