package exam;

import java.util.ArrayList;
import java.util.List;

public class leetcode77 {
	public List<List<Integer>> combine(int n, int k) {
        int len = n;
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(len, 0, k,path, res,1);
        return res;
    }
    
    private void dfs(int len, int depth, int k, List<Integer> path,List<List<Integer>> res, int begin){
        if(depth == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i<len+1;i++){
            path.add(i);
            dfs(len, depth+1, k, path, res, i+1);
            path.remove(path.size()-1);
        }
    }
}
