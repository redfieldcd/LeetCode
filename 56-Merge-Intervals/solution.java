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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<Interval>();
        if(intervals == null || intervals.size() == 0) return res;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Interval cur = intervals.get(0);
        for(Interval itv: intervals) {
            if(cur.end >= itv.start) {
                cur.start = Math.min(cur.start, itv.start); 
                cur.end = Math.max(cur.end, itv.end);
            } else {
                res.add(cur);
                cur = itv;
            }
        }
        res.add(cur);
        return res;
    }
}