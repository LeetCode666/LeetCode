package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0)
            return res;
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, res);
        return res;
    }
    
     private void dfs(int[] nums, int len, int begin, List<Integer> path,List<List<Integer>> res ){
        res.add(new ArrayList<>(path));
        for(int i = begin;i < len;i++){
            if(i>begin && nums[i]==nums[i-1])
                continue;
            path.add(nums[i]);
            dfs(nums, len, i+1, path, res);
            path.remove(path.size()-1);
        }
    }
}
