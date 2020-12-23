package exam;

import java.util.HashMap;
import java.util.Map;

public class leetcode3 {
	public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                left = Math.max(map.get(ch)+1, left);
            }
            map.put(ch, i);
            max = Math.max(max, i - left +1);
        }
        return max;
    }
}
