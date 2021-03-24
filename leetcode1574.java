package exam;

public class leetcode1574 {
	public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        while(left<n-1 && arr[left]<=arr[left+1]) left++;
        if(left == n-1) return 0;
        int right = n-1;
        while(right >0 && arr[right]>=arr[right-1]) right--;
        int result = Math.min(right, n-left-1);
        int i = 0, j = right;
        while(i<=left && j <=n-1){
            if(arr[i]<=arr[j]){
                result = Math.min(result, j-i-1);
                i++;
            }
            else{
                j++;
            }
        }
        return result;
    }
}
