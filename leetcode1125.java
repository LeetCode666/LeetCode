package exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode1125 {
	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
		Map<String, Integer> map = new HashMap<>();
		int N = req_skills.length;
		for (int i = 0; i < N; i++) map.put(req_skills[i], 1 << i);
		int M = people.size();
		int[] p = new int[M];
		for (int i = 0; i < M; i++) {
			int cur = 0;
			for (String s: people.get(i)) cur |= map.getOrDefault(s, 0);
			p[i] = cur;
		}	
		int target = 1 << N;
		int[][] dp = new int[target][];
		dp[0] = new int[0];
		int max = 0;
		for (int i = 0; i < M; i++) {
			//if (p[i] == 0) continue;
			for (int j = 0; j <= max; j++) {
				if (dp[j] == null) continue;
				int cur = j | p[i];
				if (dp[cur] == null || dp[j].length + 1 < dp[cur].length) {
					dp[cur] = Arrays.copyOf(dp[j], dp[j].length + 1);
					dp[cur][dp[j].length] = i;
				}
			}
			max |= p[i];
		}
		return dp[target - 1];
	}
}
