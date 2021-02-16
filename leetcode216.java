package exam;

import java.util.ArrayList;
import java.util.List;

public class leetcode216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k == 0 || n == 0) return res;
        dfs(n, k,0, 1, res, new ArrayList<>());
        return res;
    }
    
    private void dfs(int n, int k,int sum, int start, List<List<Integer>> res, List<Integer> path){
        if(sum == n && path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < 10;i++){
            if(sum + i > n) break;
            if(path.size() >=k) break;
            path.add(i);
            dfs(n, k , sum+i, i+1, res, path);
            path.remove(path.size()-1);
        }
    }
}
