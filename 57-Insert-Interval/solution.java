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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> before = new LinkedList();
        List<Interval> after = new LinkedList();
        List<Interval> res = new LinkedList();
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        
        for(Interval itv: intervals) {
            if(newInterval.start > itv.end) {
                before.add(itv);
            } else if(newInterval.end < itv.start) {
                after.add(itv);
            } else {
                newInterval.start = Math.min(itv.start, newInterval.start);
                newInterval.end = Math.max(itv.end, newInterval.end);
            }
        }
        
        res.addAll(before);
        res.add(newInterval);
        res.addAll(after);
        return res;
    } 
}