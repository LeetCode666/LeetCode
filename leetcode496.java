package exam;

import java.util.HashMap;
import java.util.Stack;

public class leetcode496 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len2; i++){
            while(!stack.empty() && stack.peek()<nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        int[] res = new int[len1];
        for(int i = 0; i < len1;i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
