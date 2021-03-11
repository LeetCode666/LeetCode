package exam;

import java.util.Arrays;

public class leetcode252 {
	public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1)
			return true;
        
		Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
        boolean ans = true;
        for(int i = 1;i< intervals.length;i++){
            if(intervals[i][0] < intervals[i-1][1])
                return false;
        }
        return ans;
    }
}
