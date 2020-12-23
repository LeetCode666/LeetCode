package exam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class leetcode159 {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for(int right = 0; right<s.length();right++){
            if(map.size()<3)
                map.put(s.charAt(right), right);
            if(map.size() == 3){
                int delete = Collections.min(map.values());
                left = delete + 1;
                map.remove(s.charAt(delete));
            }
            res = Math.max(right- left + 1, res);
        }
        return res;
    }
}
