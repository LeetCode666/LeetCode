package exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = numCourses;
        int[] inDegree = new int[len];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i< len;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            inDegree[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<len;i++){
            if(inDegree[i]==0)
                queue.add(i);
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int top = queue.poll();
            count++;
            for(int cur : adj.get(top)){
                inDegree[cur]--;
                if(inDegree[cur]==0)
                    queue.add(cur);
            }
        }
        
        return count == numCourses;
    }
}
