package exam;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode253 {
	public int minMeetingRooms(int[][] intervals) {
        if(intervals.length <=1)
            return intervals.length;
        Arrays.sort(intervals, (n1,n2)->(n1[0] - n2[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((n1,n2)->(n1[1]-n2[1]));
        heap.add(intervals[0]);
        for(int i = 1; i<intervals.length;i++){
            int[] pick = heap.poll();
            if(pick[1]<=intervals[i][0]){
                pick[1] = intervals[i][1];
            }
            else
                heap.add(intervals[i]);
            heap.add(pick);
        }
        return heap.size();
    }
}
