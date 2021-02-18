package exam;

public class leetcode526 {
	private int res;
    public int countArrangement(int n) {
        res = 0;
        boolean[] visited = new boolean[n+1];
        dfs(n+1, visited,1);
        return res;
    }
    
    private void dfs(int len, boolean[] visited, int count){
        if(count == len){
            res++;
            return;
        }
        for(int i = 1; i < len;i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(i % count == 0 || count%i == 0){
                dfs(len, visited, count+1);
            }
            visited[i] = false;
        }
    }
}
