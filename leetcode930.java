package exam;

public class leetcode930 {
	public int numSubarraysWithSum(int[] A, int S) {
        return helper(A, S) - helper(A, S-1);
    }
    
    private int helper(int[]A, int S){
        if(S<0) return 0;
        int res = 0, left = 0;
        for(int right = 0; right < A.length;right++){
            S-=A[right];
            while(S<0){
                S+=A[left];
                left++;
            }
            res+= (right-left+1);
        }
        return res;
    }
}
