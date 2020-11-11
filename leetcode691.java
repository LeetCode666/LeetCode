package exam;

import java.util.Arrays;

public class leetcode691 {
	public int minStickers(String[] stickers, String target) {
        int n = stickers.length, m = target.length();
        int[] dp = new int[1 << m];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(String sticker: stickers){
            for(int status = 0; status < (1 << m); status++){
                if(dp[status] == -1){
                    continue;
                }
                int curStatus = status;
                for(char c: sticker.toCharArray()){
                    for(int i = 0 ; i < m ; i++){
                        if(c == target.charAt(i) && (curStatus & (1 << i)) == 0){
                            curStatus |= 1 << i;
                            break;
                        }
                    }
                }
                dp[curStatus] = dp[curStatus] == -1 ? dp[status] + 1: Math.min(dp[curStatus], dp[status] + 1);
            }
        }
        return dp[(1 << m) - 1];
    }
}
