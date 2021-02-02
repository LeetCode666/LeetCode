package exam;

import java.util.ArrayList;
import java.util.List;

public class leetcode78 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int len = nums.length;
        dfs(nums, len, 0, res, new ArrayList<Integer>());
        return res;
    }
    private void dfs(int[] nums, int len, int start,List<List<Integer>> res, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i = start; i < len; i++){
            path.add(nums[i]);
            dfs(nums, len, i+1, res, path);
            path.remove(path.size()-1);
        }
    }
}
