package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode743 {
	public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge: times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        boolean[] visited = new boolean[N + 1];
        int[] minDis = new int[N + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[K] = 0;
        pq.offer(new int[]{0, K});
        int max = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[1];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            int curDis = cur[0];
            max = curDis;
            N--;
            if(!graph.containsKey(curNode)) continue;
            for(int[] next : graph.get(curNode)){
                if(!visited[next[0]]&& next[1] + curDis <minDis[next[0]])
                    pq.offer(new int[]{curDis + next[1], next[0]});
            }
        }
        
        return N == 0 ? max : -1;
    }
}
