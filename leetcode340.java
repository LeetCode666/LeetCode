package exam;

import java.util.HashMap;
import java.util.Map;

public class leetcode340 {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0 || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0;
        for(int i = 0; i < s.length();i++){
            char cur = s.charAt(i);
            if(map.getOrDefault(cur, 0) == 0) k--;
            map.put(cur, map.getOrDefault(cur,0)+1);
            while(k<0){
                char curLeft = s.charAt(left);
                map.put(curLeft, map.get(curLeft)-1);
                if(map.get(curLeft) == 0)
                    k++;
                left++;
            }
            res = Math.max(i-left+1, res);
        }
        return res;
    }
}
