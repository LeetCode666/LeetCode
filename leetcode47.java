package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(visited, nums.length, path, res, nums);
        return res;
    }
    private void dfs(boolean[] visited, int len, List<Integer> path, List<List<Integer>> res, int[] nums){
        if(path.size() == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len;i++){
            if(visited[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            path.add(nums[i]);
            dfs(visited, len, path, res, nums);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}
