package exam;

public class leetcode1004 {
	public int longestOnes(int[] A, int K) {
        int left = 0;
        int res = 0;
        for(int right = 0; right < A.length; right++){
            int cur = A[right];
            if(cur==0) K--;
            while(K<0){
                if(A[left] == 0)
                    K++;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
