package exam;

import java.util.HashMap;
import java.util.Map;

public class leetcode1577 {
	public int numTriplets(int[] a, int[] b) {
        return cnt(a, b) + cnt(b, a);
    }
    
    private int cnt(int[] a, int[] b) {
        int res = 0, m = a.length;
        for (int i = 0; i < m; i++) {
            Map<Long, Integer> map = new HashMap<>();
            long t = ((long) a[i]) * ((long) a[i]);
            for (long n : b){
                if (t % n == 0) res += map.getOrDefault(t / n, 0);
                map.put(n, map.getOrDefault(n, 0) + 1); 
            }
        }
        return res;
    }
}
