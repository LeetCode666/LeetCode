package exam;

public class leetcode1358 {
	public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left= 0;
        int res = 0;
        for(int right = 0; right < s.length();right++){
            int cur = s.charAt(right) - 'a';
            count[cur]++;
            while(count[0] > 0 && count[1] >0 && count[2] >0){
                res += s.length() - right;
                int curLeft = s.charAt(left) -'a';
                count[curLeft]--;
                left++;
            }
        }
        return res;
    }
}
