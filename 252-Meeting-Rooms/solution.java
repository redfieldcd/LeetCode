/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval n1, Interval n2) {
                return n1.start - n2.start;
            }
        });
        
        int end = intervals[0].end;
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < end) {
                return false;
            }
            end = Math.max(end, intervals[i].end);
        }
        return true;
    }
}