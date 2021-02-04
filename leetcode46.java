package exam;

import java.util.ArrayList;
import java.util.List;

public class leetcode46 {
	public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0)
            return res;
        boolean[] used = new boolean[len];
        ArrayList<Integer> path = new ArrayList<>();
        
        bfs(nums, len, 0 , used, path, res);
        return res;
    }
    
    public void bfs(int[]nums, int len, int depth, boolean[] used, ArrayList<Integer> path, List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i++){
            if(used[i])
                continue;
            path.add(nums[i]);
            used[i] = true;
            bfs(nums, len, depth+1, used, path, res);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
