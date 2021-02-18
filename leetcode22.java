package exam;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String path = "";
        dfs(n, n, path, res);
        return res;
    }
    
    private void dfs(int left, int right, String path, List<String> res){
        if(left == 0 && right == 0){
            res.add(new String(path));
            return;
        }
        if(left > 0){
            path += "(";
            dfs(left-1, right, path, res);
            path = path.substring(0, path.length()-1);
        }
        if(right > left ){
            path += ")";
            dfs(left, right-1, path, res);
            path = path.substring(0, path.length()-1);
        }
    }
}
