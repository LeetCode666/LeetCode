package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, 0, res, path);
        return res;
    }
    
    private void dfs(int[] nums, int target, int sum, int start, List<List<Integer>> res, List<Integer> path){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < nums.length;i++){
            if(nums[i] + sum > target)break;
            if(i>start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            dfs(nums, target, sum + nums[i], i+1, res, path);
            path.remove(path.size()-1);
        }
    }
}
