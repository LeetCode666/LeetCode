package exam;

import java.util.HashMap;
import java.util.Map;

public class leetcode992 {
	public int subarraysWithKDistinct(int[] A, int K) {
        return helper(A, K) - helper(A, K-1);
    }
    
    private int helper(int[] A, int K){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for(int i = 0; i < A.length;i++){
            int cur = A[i];
            if(map.getOrDefault(cur, 0) == 0) K--;
            map.put(cur, map.getOrDefault(cur,0)+1);
            while(K<0){
                map.put(A[left], map.get(A[left])-1);
                if(map.get(A[left]) == 0) K++;
                left++;
            }
            res += i -left + 1;
        }
        return res;
    }
}
