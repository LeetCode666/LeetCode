package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        
        dfs(candidates, len, target, 0, path, res);
        return res;
    }
    
    private void dfs(int[] candidates, int len, int target, int begin, List<Integer> path, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i<len; i++){
            if(target - candidates[i]<0)
                break;
            path.add(candidates[i]);
            dfs(candidates, len, target - candidates[i], i, path, res);
            path.remove(path.size()-1);
        }
    }
}
